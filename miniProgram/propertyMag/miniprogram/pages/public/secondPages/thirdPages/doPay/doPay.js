// miniprogram/pages/public/payPropertyFee/payPropertyFee.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    radioItems: [
      { name: '微信支付', value: '0', checked: true  },
      // { name: '支付宝支付', value: '1'},
      // { name: '银联支付', value: '2' }
    ],


    userInfoDesc: null,
    costItemList: [],//费用项目
    houseCostList: null,//房屋费用

  },

  radioChange: function (e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value);

    var radioItems = this.data.radioItems;
    for (var i = 0, len = radioItems.length; i < len; ++i) {
      radioItems[i].checked = radioItems[i].value == e.detail.value;
    }

    this.setData({
      radioItems: radioItems
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    var that = this;
    that.setData({
      userInfoDesc: JSON.parse(options.userInfoDesc),
      houseCostList: JSON.parse(options.houseCostList),
      costItemList: JSON.parse(options.houseCostList).list
      /*costItemList: [{
                        "costItemName": "物管22",
                        "price": 500,
                        "costStartDate": 1601481600000,
                        "costEndDate": 1604073600000,
                        "costDate": null,
                        "moneyNote": "500",
                        "receivableMoney": 500
                  },
                    {
                          "costItemName": "物管22",
                          "price": 500,
                          "costStartDate": 1598889600000,
                          "costEndDate": 1601395200000,
                          "costDate": null,
                          "moneyNote": "500",
                          "receivableMoney": 500}]*/
    });
  },

  //立即缴费
  chargeHouseCost: function(){
    
    var that = this;
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/FuniController/chargeHouseCost', //仅为示例，并非真实的接口地址
      data: {
        orderNo: that.data.houseCostList.orderNo,
        money: that.data.houseCostList.money,
        houseid: that.data.houseCostList.houseid,
        roomnumber: that.data.houseCostList.roomnumber
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        console.log(res.data.data);
        if (res.data.status == 1) {
          wx.reLaunch({
            url: '/pages/public/secondPages/thirdPages/doPay/successPage',
          })
        } else {
          wx.showToast({
            title: '出错了，请重试！',
            icon: 'none'
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
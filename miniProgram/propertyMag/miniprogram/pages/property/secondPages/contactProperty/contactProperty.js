// miniprogram/pages/property/secondPages/contactProperty/contactProperty.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    corridorPhone: null,//楼道长电话
    peopertyPhone: null,//物业电话
  },


  //js
  callPhone: function (e) {
    var callNumber = e.currentTarget.dataset.number
    wx.makePhoneCall({
      phoneNumber: callNumber
    })
  },

  //获取联系方式
  findCorridorPhone: function(){
    var that = this;
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/IndexController/findCorridorPhone',
      data: {
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success: function (res) {
        wx.hideLoading();
        var data = res.data; // 接口相应的json数据
        if(data.status == 1){
          var dataList = data.data; 
          console.log(dataList);
          that.setData({
            corridorPhone: dataList[0].phone,
            peopertyPhone: dataList[1].phone
          })
        }else{
          wx.showToast({
            title: '出错了,错误信息：'+data.msg,
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.findCorridorPhone();
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
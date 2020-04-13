// miniprogram/pages/public/payPropertyFee/payPropertyFee.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataList: [],
  },

  //立即处理
  gotoSolve: function (e) {
    wx.showLoading({
      title: '加载中',
    });

    wx.navigateTo({
      url: "../../thirdPages/repair/solve/solve?dataList=" + JSON.stringify(this.data.dataList),
    })
  },

  //查看详情
  gotoViewDetails: function (e) {
    wx.showLoading({
      title: '加载中',
    });

    wx.navigateTo({
      url: "../../thirdPages/repair/details/details?dataList=" + JSON.stringify(this.data.dataList),
    })
  },

  //查询数据
  loadData: function(){
    var that = this;
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/getRepairList', //仅为示例，并非真实的接口地址
      data: {
        
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        console.log(res.data);
        if (res.data.status == 1){
          that.setData({
            dataList: res.data.data
          });
        }else{
          wx.showToast({
            title: '出错了',
            icon: 'none'
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
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
    this.loadData();
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
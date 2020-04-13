// miniprogram/pages/property/myAccountDemo/myAccountDemo.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfoDesc: app.globalData.userInfoDesc,
    userStatus: app.globalData.userStatus,
    powerList: [],
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
    this.setData({
      "userInfoDesc": app.globalData.userInfoDesc,
      "userStatus": app.globalData.userStatus,
      "powerList": app.globalData.userInfoDesc.powername,
    });
    console.log(app.globalData.userInfoDesc.powername);

    //console.log(app.globalData.userInfo);
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
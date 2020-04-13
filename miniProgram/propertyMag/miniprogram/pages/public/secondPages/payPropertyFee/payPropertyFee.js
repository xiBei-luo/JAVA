// miniprogram/pages/public/payPropertyFee/payPropertyFee.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },

  doPayFee: function (e) {
    wx.showLoading({
      title: '加载中',
    });

    setTimeout(function () {
      wx.hideLoading()
    }, 2000);


    wx.navigateTo({
      url: "../thirdPages/doPay/doPay",
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (3 == app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '您还没有绑定业主，请认证后操作！',
        confirmText: "立即认证",
        cancelText: "暂不认证",
        success: function (res) {
          console.log(res);
          if (res.confirm) {
            wx.reLaunch({
              url: '/pages/public/firstVisit/firstVisit'
            })
          } else {
            wx.navigateBack({})
          }
        }
      });
    } else if (2 == app.globalData.userStatus){
      wx.showModal({
        title: '提示',
        content: '业主信息正在审核中，暂时不能缴费！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
    } else if (!app.globalData.userStatus){
      wx.showModal({
        title: '提示',
        content: '出错了，请稍后再试！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
    }
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
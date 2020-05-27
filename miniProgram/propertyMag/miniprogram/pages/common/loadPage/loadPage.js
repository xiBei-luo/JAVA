// miniprogram/pages/common/loadPage/loadPage.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    flag: false,
    IsAuthorization: false,//是否成功获取openid
  },

  

  showMask: function () {
    this.setData({ flag: false })
  },
  closeMask: function () {
      this.setData({ flag: true })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //console.log(that.data.IsAuthorization);
    app.watch(that.watchBack);

    
    //若先执行了app.js,则监控不到全局变量的变化则会一直阻塞在此页面，加此段代码在1秒后不论是否监控到全局变量变化都对页面进行跳转
    setTimeout(() => {
      wx.switchTab({
        url: "/pages/public/home/home",
      })
    }, 1000);
    
  },

  //监听是否成功获取openid
  watchBack: function (value){
    console.log("==========是否成功获取用户信息："+value+"=========");
    this.setData({
      IsAuthorization: value
    });
    

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
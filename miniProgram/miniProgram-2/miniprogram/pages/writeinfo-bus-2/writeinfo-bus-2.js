// miniprogram/pages/writeinfo-bus/writeinfo-bus.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: "",//店铺地址
    region: ['四川省', '成都市', '武侯区'],//店铺地址
    customItem: '全部',
    address: '',//详细地址
    phone: '',//联系方式
    time_begin: "09:00",//营业开始时间
    time_end: "21:00",//营业结束时间
    declaration: ""//店铺描述

  },

  //店铺名称改变
  bindNameChange: function (e) {
    this.setData({
      name: e.detail.value
    })
  },

  //店铺地址改变
  bindRegionChange: function (e) {
    this.setData({
      region: e.detail.value
    })
  },
  //店铺详细地址改变
  bindAddressChange: function (e) {
    this.setData({
      address: e.detail.value
    })
  },
  //联系方式改变
  bindPhoneChange: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },
  //营业时间改变
  bindTimeBeginChange: function (e) {
    this.setData({
      time_begin: e.detail.value
    })
  },
  //营业时间改变
  bindTimeEndChange: function (e) {
    this.setData({
      time_end: e.detail.value
    })
  },
  //店铺描述改变
  bindDescChange: function (e) {
    this.setData({
      declaration: e.detail.value
    })
  },

  //下一步
  gotoNext: function () {
    wx.showLoading({
      title: '加载中',
    });

    setTimeout(function () {
      wx.hideLoading()
    }, 2000);
    
    //页面跳转
     wx.navigateTo({
       url: "../writeinfo-bus-3/writeinfo-bus-3?baseInfo=" + JSON.stringify(this.data),
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
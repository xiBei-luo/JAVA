// miniprogram/pages/public/showNews/showNews.js
var WxParse = require('../../../components/wxParse/wxParse.js');
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataList: [],
    newsContent: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    WxParse.wxParse('article', 'html', this.data.article, this, 5);


    var that = this;
    var parentDataId = JSON.parse(options.id);
    var parentData = null;
    console.log(parentDataId);

    //请求新闻内容
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/NewsController/getNews',
      data: {
        id: parentDataId
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        parentData = res.data.data;
        console.log(parentData);
        var article = parentData.content;
        WxParse.wxParse('article', 'html', article, that, 5);
        that.setData({
          dataList: parentData,
          newsContent: article
        })

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
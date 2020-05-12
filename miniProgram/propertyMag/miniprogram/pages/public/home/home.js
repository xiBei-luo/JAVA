// miniprogram/pages/public/home/home.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userNewsList: [],
    //轮播图列表
    carouselList: [{
        "id": "101",
      "img": "/images/home/banner1.jpg",
        "title": "",
        "url": "https://www.baidu.com/"
      },
      {
        "id": "102",
        "img": "/images/home/banner2.jpg",
        "title": "百度翻译",
        "url": "https://fanyi.baidu.com/"
      },
      {
        "id": "103",
        "img": "/images/home/banner3.jpg",
        "title": "百度地图",
        "url": "https://map.baidu.com/"
      },
      {
        "id": "104",
        "img": "/images/home/banner4.jpg",
        "title": "简书是一个写博客的网站，挺好用的，可以试试看",
        "url": "https://www.jianshu.com/"
      }
    ],
  },

  //点击了轮播图
  chomeCarouselClick: function (event) {
    var urlStr = event.currentTarget.dataset.url;
    console.log("点击了轮播图：" + urlStr);
    // wx.navigateTo({
    //   url: 'test?id=1'
    // })
  },


  //查看公告详情
  gotoShowNews: function(e){
    //../showNews/showNews
    var dataList = e.currentTarget.dataset.newslist;
    console.log(dataList);
    wx.navigateTo({
      url: '../showNews/showNews?id=' + dataList.id,
    })
  },

 

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;

    // setTimeout(function () {
       
    // }, 1000) //延迟时间 这里是1秒

    console.log("用户状态："+app.globalData.userStatus);
    if(app.globalData.userStatus == 1){
      //请求公告列表——正式用户
      wx.request({
        url: 'https://www.cloplex.com/property/index.php/NewsController/getNewsList',
        data: {
          type: 1,
          offset: 1
        },
        header: {
          'content-type': "application/x-www-form-urlencoded", // 默认值
          'cookie': wx.getStorageSync("sessionid")
        },
        method: "POST",
        success(res) {
          console.log(res.data.data);
          that.setData({
            userNewsList: res.data.data
          })
        }
      })
    }else{
      //获取操作手册
      wx.request({
        url: 'https://www.cloplex.com/property/index.php/IndexController/selectNews',
        data: {
          id: ""
        },
        header: {
          'content-type': "application/x-www-form-urlencoded", // 默认值
          'cookie': wx.getStorageSync("sessionid")
        },
        method: "POST",
        success(res) {
          console.log(res.data.data);
          that.setData({
            userNewsList: res.data.data
          })
        }
      })
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
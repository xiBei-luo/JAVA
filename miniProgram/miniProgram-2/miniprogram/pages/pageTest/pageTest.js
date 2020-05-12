// miniprogram/pages/pageTest/pageTest.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    totalDataCount: 0, // 总数据条数
    currentPage: 0,
    articles: [] // 存放所有的文章
  },

  /**
   * 滚动到某个view
   */
  scrollToView: function (e) {
    var that = this
    const dataset = e.currentTarget.dataset;
    var mark = dataset.mark
    console.log("scroll to :" + mark);
    that.setData({
      toView: mark
    })
  },
  /**
   * 加载初始数据,有时候为了提升页面打开速度，会将所有数据合并到一个接口中返回，然后列表中的第二页数据开始，使用其它接口返回，即分页获取数据时，仅获取下一页的数据。（这里仅做示例，因为每一页数据都取一样的。在实际开发中可以考虑这样分开。）
   */
  loadInitData: function () {
    var that = this
    var currentPage = 0; // 因为数组下标是从0开始的，所以这里用了0
    var tips = "加载第" + (currentPage+1) + "页";
    console.log("load page " + (currentPage + 1));
    wx.showLoading({
      title: tips,
    })
    // 刷新时，清空dataArray，防止新数据与原数据冲突
    that.setData({
      dataArray: []
    })
    // 请封装自己的网络请求接口，这里作为示例就直接使用了wx.request.
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/getRepairList',
      data: {
        offset: currentPage+1
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success: function (res) {
        wx.hideLoading();
        var data = res.data; // 接口相应的json数据
        var articles = data.data; // 接口中的data对应了一个数组，这里取名为 articles
        var totalDataCount = articles.length;
        console.log(articles);
        // console.log(articles);
        console.log("totalDataCount:"+totalDataCount);
        that.setData({
          ["dataArray["+currentPage+"]"]: articles,
          currentPage: currentPage,
          totalDataCount: totalDataCount
        })
      }
    })

  },

  /**
   * 加载下一页数据
   */
  loadMoreData: function () {
    var that = this
    var currentPage = that.data.currentPage; // 获取当前页码
    currentPage += 1; // 加载当前页面的下一页数据
    var tips = "加载第" + (currentPage + 1) + "页";
    console.log("load page " + (currentPage + 1));
    wx.showLoading({
      title: tips,
    })
    // 请封装自己的网络请求接口，这里作为示例就直接使用了wx.request.
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/getRepairList',
      data: {
        offset: currentPage
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success: function (res) {
        wx.hideLoading();
        var data = res.data; // 接口相应的json数据
        var articles = data.data; // 接口中的data对应了一个数组，这里取名为 articles

        // 计算当前共加载了多少条数据，来证明这种方式可以加载更多数据
        var totalDataCount = that.data.totalDataCount;
        totalDataCount = totalDataCount + articles.length;
        console.log("totalDataCount:" + totalDataCount);
        
        // 直接将新一页的数据添加到数组里
        that.setData({
          ["dataArray[" + currentPage + "]"]: articles,
          currentPage: currentPage,
          totalDataCount: totalDataCount
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this

    // 加载页面初始化时需要的数据
    setTimeout(function () {
      that.loadInitData();
    }, 1000) //延迟时间 这里是1秒
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
// miniprogram/pages/property/thirdPages/suggest/solve/solve.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    files: [],
    dataList: [],
  },





  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id);
    var that = this;
    var parentDataId = options.id;
    var parentData = [];

    //根据id请求数据
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/NewsController/getNews',
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


        var contextUrl = "https://www.cloplex.com";
        var parentDataImgTmp = JSON.parse(parentData.newsimg);
        var parentDataImg = [];

        for (var i = 0; i < parentDataImgTmp.length; i++) {
          var absolutPathStr = parentDataImgTmp[i].substring(13);

          var imgPath = contextUrl + absolutPathStr;

          parentDataImg.push(imgPath);
        }


        console.log(parentData);
        that.setData({
          dataList: parentData,
          files: parentDataImg
        });
        wx.hideLoading();

      }
    })

    
  },


  //预览图片
  previewImage: function (e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
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
    var t = getCurrentPages()[getCurrentPages().length - 2];
    t.setData({
      offset: 0
    });
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
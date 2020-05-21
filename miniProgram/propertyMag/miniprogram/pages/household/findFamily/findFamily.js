// miniprogram/pages/property/thirdPages/auditing/auditing.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    dataList: [],
  },

  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfoDesc
    });

    var params = {
      id: that.data.userInfo.id,
    };
    console.log(params);
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/UserController/findFamily', //仅为示例，并非真实的接口地址
      data: params,
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        console.log(res);
        wx.hideLoading();//关闭遮罩
        if(res.data.status == 1){
          if (res.data.data){
            that.setData({
              dataList: res.data.data
            });
          }
        }else{
          wx.showToast({
            title: '出错了，错误信息：'+res.msg,
            icon: 'none',
            duration: 1000
          })
        }
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
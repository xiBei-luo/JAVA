// miniprogram/pages/property/thirdPages/auditing/auditing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userData: null,
    auditingResult: 1,
    auditingReson: null,
  },

  //输入未通过原因
  inputReson: function(e){
    var that = this;
    that.setData({
      auditingReson: e.detail.value
    });
  },

  //提交审核
  submitAuditing: function(e){
    var that = this;
    console.log(that.data.auditingResult);
    console.log(that.data.userData);

    var params = {
      id: that.data.userData.id,
      status: that.data.auditingResult,
      remark: that.data.auditingReson,
      category: that.data.userData.category
    };
    console.log(params);
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/UserController/updateUserStatus', //仅为示例，并非真实的接口地址
      data: params,
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        console.log(res.data);
        wx.hideLoading();//关闭遮罩

        if(res.data.status == 1){
          if(that.data.userData.category != 4){
            wx.showModal({
              title: '提示',
              content: '审核成功，是否立即给该用户授权！',
              confirmText: "立即授权",
              cancelText: "以后再说",
              success: function (res) {
                if (res.confirm) {
                  //parentPage为1，表示审核通过后直接授权
                  wx.navigateTo({
                    url: '/pages/property/thirdPages/setRole/setRole?id=' + that.data.userData.id+'&parentPage=1'
                  })
                } else {
                  setTimeout(function(){
                    var t = getCurrentPages()[getCurrentPages().length - 2];
                    t.loadInitData();
                    wx.navigateBack({
    
                    })
                  }, 1000);
                }
              }
            });
          }else{
            wx.showToast({
              title: '审核成功',
              icon: 'success',
              duration: 1000,
              success: function(){
                setTimeout(function(){
                  var t = getCurrentPages()[getCurrentPages().length - 2];
                  t.loadInitData();
                  wx.navigateBack({
  
                  })
                }, 1000);
              }
            });
          }
        }else{
          wx.showToast({
            title: '出错了,错误信息：'+res.msg,
            icon: 'none',
            duration: 1000
          });
        }

      }
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log(options);
    that.setData({
      userData: JSON.parse(options.userData)
    });
  },

  //审核
  doAuditing: function(e){
    var that = this;
    var result = e.currentTarget.dataset.result;
    that.setData({
      auditingResult: result
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
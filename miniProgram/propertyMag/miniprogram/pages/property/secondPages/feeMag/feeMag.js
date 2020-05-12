// miniprogram/pages/public/payPropertyFee/payPropertyFee.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataList: [],
  },

  //已收费，修改状态值
  gotoSolve: function (e) {
    var code = e.currentTarget.dataset.code;//成功收款为1  未收款3
    console.log(code);

    var that = this;
    wx.showLoading({
      title: '请稍等',
    })
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/FuniController/updateFeesStatus', //仅为示例，并非真实的接口地址
      data: {
        id: that.data.dataList.id,
        status: code
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        var retDataArr = res.data.data;
        console.log(res.data);
        if (res.data.status == 1) {
          wx.showToast({
            title: '成功',
            duration: 3000,
            success: function () {
              that.loadInitData(that.data.dataList.id)
            }
          })
        } else {
          wx.showToast({
            title: '出错了,'+res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  },

  //加载数据
  loadInitData: function(parentDataId){
    var that = this;
    that.setData({
      dataList: []
    });
    var parentData = [];
    //根据id请求数据
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/FuniController/findRecharge',
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
        that.setData({
          dataList: parentData
        });
        wx.hideLoading();

      }
    })
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var parentDataId = options.id;

    //parentDataId = 2;

    that.loadInitData(parentDataId);

    
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
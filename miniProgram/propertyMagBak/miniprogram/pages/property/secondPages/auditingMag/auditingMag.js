// miniprogram/pages/property/secondPages/auditingMag/auditingMag.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // accounts: ["选择楼栋","1栋", "2栋", "3栋"],
    // accountIndex: 0,
    
    inputShowed: false,
    inputVal: "",
    offset: 0,
    auditingList: [],
  },

  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    var that = this;
    wx.showLoading({
      title: '请稍等',
    });
    that.setData({
      inputVal: e.detail.value
    });
    console.log("关键字：" + this.data.inputVal);
    that.loadData();
  },


  //加载数据
  loadData: function () {
    var that = this;
    // 页数+1
    that.data.offset = that.data.offset + 1;
    that.setData({
      offset: that.data.offset
    });
    // 显示加载图标
    wx.showLoading({
      title: '玩命加载中',
    });
    console.log("pages," + that.data.offset);
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/UserController/selectUser', //仅为示例，并非真实的接口地址
      data: {
        searchKey: that.data.inputVal,
        offset: 1
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        console.log(res.data);
        wx.hideLoading();//关闭遮罩

        if (that.data.inputVal) {
          that.setData({
            auditingList: res.data.data
          })
        } else{
          if (!res.data.data) {
            // 显示加载图标
            wx.showToast({
              title: '到底了',
              icon: "none",
              duration: 1000
            })
          } else {
            var retList = that.data.auditingList.concat(res.data.data);
            console.log(res.data.data);
            that.setData({
              auditingList: retList
            })
          }
        }
        
      }
    })
  },


  //审核  category管理员（1）、物业（2）、项目部（3），还是业主（4）
  doAuditing: function(e){
    var userData = e.currentTarget.dataset.userdata;
    console.log(userData);

    wx.navigateTo({
      url: '../../thirdPages/auditing/auditing?userData=' + JSON.stringify(userData),
    });

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
    this.loadData();
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
    var that = this;

    this.loadData();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
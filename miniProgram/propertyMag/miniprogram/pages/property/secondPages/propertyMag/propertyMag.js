//var base64 = require("../images/base64");
var app = getApp();
Page({
  data: {
    inputShowed: false,
    inputVal: "",
    offset: 0,
    dataList: [],
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

  //查询数据
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
        status: "1",//查询正常用户
        offset: (that.data.inputVal) ? 1 : that.data.offset
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        console.log(res);
        var retDataArr = res.data.data;
        wx.hideLoading();//关闭遮罩

        if (that.data.inputVal) {
          that.setData({
            dataList: retDataArr
          })
        } else {
          if (!retDataArr) {
            // 显示加载图标
            wx.showToast({
              title: '到底了',
              icon: "none",
              duration: 1000
            })
          } else {
            console.log(retDataArr);
            var retList = that.data.dataList.concat(retDataArr);
            that.setData({
              dataList: retList
            })
          }
        }

      }
    })
  },


  onLoad: function () {

    this.loadData();
    this.setData({
      //icon: base64.icon20,
      slideButtons: [{
        text: '角色设置',
        src: '/page/weui/cell/icon_love.svg', // icon的路径
      }, {
        text: '单独授权',
        extClass: 'test',
        src: '/page/weui/cell/icon_star.svg', // icon的路径
      }, {
        type: 'warn',
        text: '删除',
        extClass: 'test',
        src: '/page/weui/cell/icon_del.svg', // icon的路径
      }],
    });


    
  },


  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function(){
    this.onLoad();
  },


  //点击功能项
  slideButtonTap(e) {
    console.log(e);
    var userData = e.currentTarget.dataset.userdata;
    console.log(userData.id);
    var operationIndex = e.detail.index;
    if (0 == operationIndex) {
      wx.navigateTo({
        url: '/pages/property/thirdPages/setRole/setRole?id=' + userData.id + '&roleid=' + userData.roleid,
      })
    } else if (1 == operationIndex) {
      wx.navigateTo({
        url: '/pages/property/thirdPages/grand/grand?id=' + userData.id,
      })
    } else if (2 == operationIndex) {
      wx.showModal({
        title: '提示',
        content: '确认删除【' + userData.username+'】吗？',
        confirmText: "确认删除",
        cancelText: "放弃删除",
        success: function (res) {
          console.log(res);
          if (res.confirm) {
            console.log('用户点击确认删除')
          } else {
            console.log('用户点击放弃删除')
          }
        }
      });
    }
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
});
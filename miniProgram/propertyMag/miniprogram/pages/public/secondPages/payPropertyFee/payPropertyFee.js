// miniprogram/pages/public/payPropertyFee/payPropertyFee.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfoDesc: null,
    costItemList: [],  //收费项目
    houseCostList: null,//房屋费用

  },

  //小程序端缴费引导去公众号端缴费
  doPayFee: function (e) {
    wx.showToast({
      title: '请前往公众号缴费',
      icon: 'none',
      duration: 5000
    })
    // var that = this;
    // wx.navigateTo({
    //   url: "../thirdPages/doPay/doPay?userInfoDesc=" + JSON.stringify(that.data.userInfoDesc) + "&houseCostList=" + JSON.stringify(that.data.houseCostList),
    // })
  },

  //查看缴费历史
  gotoFeeHistory: function(){
    var that = this;
    wx.navigateTo({
      url: "/pages/household/pay/pay?userInfoDesc=" + that.data.userInfoDesc,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    
    that.setData({
      userInfoDesc: app.globalData.userInfoDesc
    });
    console.log(that.data.userInfoDesc);

    if (3 == app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '您还没有绑定业主，请认证后操作！',
        confirmText: "立即认证",
        cancelText: "暂不认证",
        success: function (res) {
          console.log(res);
          if (res.confirm) {
            wx.reLaunch({
              url: '/pages/public/firstVisit/firstVisit'
            })
          } else {
            wx.navigateBack({})
          }
        }
      });
      return;
    } else if (2 == app.globalData.userStatus){
      wx.showModal({
        title: '提示',
        content: '业主信息正在审核中，暂时不能缴费！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
      return;
    } else if (!app.globalData.userStatus){
      wx.showModal({
        title: '提示',
        content: '出错了，错误信息：未获取到用户状态',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
      return;
    }


    //category    管理员（1）、物业（2）、项目部（3），还是业主（4）
    if (app.globalData.userInfoDesc.category == 2 || app.globalData.userInfoDesc.category == 3){
      wx.showModal({
        title: '提示',
        content: '抱歉，您暂无此功能使用权限！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
      return;
    }

    //获取收费项目
    this.getCostItemList();
  },

  //获取收费项目
  getCostItemList: function(){
    var that = this;
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/FuniController/costItemList', //仅为示例，并非真实的接口地址
      data: {
        
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        console.log(res.data.data);
        if(res.data.status == 1){
          var retData = res.data.data;
          var retDataArr = [];
          for (var i = 0; i < retData.length; i++) {
            retDataArr.push(retData[i].itemCode);
          }
          that.setData({
            costItemList: retDataArr
          });

          //查询房屋费用
          that.getHouseCostList(retDataArr);
        }else{
          wx.showToast({
            title: '出错了，错误信息：'+res.data.msg,
            icon: 'none'
          })
        }
      }
    })
  },

  //查询房屋费用
  getHouseCostList: function (costItemListP){
    console.log(costItemListP);
    var that = this;
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/FuniController/houseCostList', //仅为示例，并非真实的接口地址
      data: {
        costitemlist: costItemListP
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        console.log(res.data);
        if (res.data.status == 1){
          that.setData({
            houseCostList: res.data.data
          });
        }else{
          wx.showToast({
            title: '出错了，错误信息：'+res.data.msg,
            icon: 'none'
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
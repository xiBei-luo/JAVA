// pages/household/identify/identify.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    region: ['四川省', '成都市', '武侯区'],//店铺地址
    username: "",
    companyid: "",
    companyname: "",
    subjectid: "",
    subjectname: "",
    phone: "",
    openid: "",
    checkboxItems: [
      { name: '本部', value: '1'},
      { name: '其他项目部', value: '2' }
    ],
  },

  //选择所属部门
  checkboxChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value);
    var selectVal = e.detail.value;

    var checkboxItems = this.data.checkboxItems;
    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = checkboxItems[i].value == selectVal;
    }

    this.setData({
      checkboxItems: checkboxItems
    });

    if (selectVal == 2) {
      
      wx.navigateTo({
        url: "/pages/household/villageList/villageList?region=" + this.data.region + "&companyid=" + this.data.companyid,
      });
    }
  },



 

  //选择物业
  selectCompany: function () {
    var region = this.data.region;
    wx.navigateTo({
      url: "/pages/property/companyList/companyList?region=" + region,
    });
  },


  //提交认证
  gotoVillage: function () {
    var that = this;
    wx.showLoading({
      title: '请稍等',
    });

    //获取缓存中的openid
    wx.getStorage({
      key: 'openid',
      success(res) {
        console.log(res.data)
        that.setData({
          openid: res.data
        })
      }
    });

    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/insertUser', //仅为示例，并非真实的接口地址
      //url: 'http://localhost:8088/User/insertUser',
      data: {
        //region: that.data.region,
        openid: that.data.openid,
        username: that.data.username,
        phone: that.data.phone,
        propertyid: that.data.companyid,
        subjectid: that.data.subjectid,
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        console.log(res.data);

        if (res.data.status == 1) {
          app.globalData.userStatus = 2;
          //页面跳转
          wx.switchTab({
            url: "../../public/home/home",
          })
        } else {
          wx.showLoading({
            title: '请求出错了',
          });
          setTimeout(function () {
            wx.hideLoading()
          }, 2000);
        }



      }
    })



  },


  //店铺地址改变
  bindRegionChange: function (e) {
    this.setData({
      region: e.detail.value
    })
  },


  //获取input值
  getInputValue: function (e) {
    var type = e.target.dataset.type;
    console.log(type);
    console.log(e.detail.value);
    this.setData({
      [type]: e.detail.value
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
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
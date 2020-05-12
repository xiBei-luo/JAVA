// pages/household/identify/identify.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    region: ['四川省', '成都市', '武侯区'],//店铺地址
    username: "",
    subjectid: "",
    subjectname: "",
    interfaceid: "",
    phone: "",
    roomnumber: "",
    openid: "",
    multiIndex: [0,0,0],
    multiArray: [],
    build: "",


  },

  //选择小区
  selectVillage: function(){
    var region = this.data.region;
    wx.navigateTo({
      url: "/pages/household/villageList/villageList?region=" + region,
    });
  },

  //提交认证
  gotoVillage: function(){
    var that = this;
    
    // wx.showToast({
    //   title: that.data.subjectid,
    //   duration: 5000
    // })
    if (that.data.subjectid == "" || that.data.subjectid == null){
      wx.showToast({
        title: '请选择所属小区',
        icon: 'none'
      })
      return false;
    }
    if (that.data.username == "" || that.data.username == null) {
      wx.showToast({
        title: '请输入姓名',
        icon: 'none'
      })
      return false;
    }
    if (that.data.phone == "" || that.data.phone == null) {
      wx.showToast({
        title: '请输入手机号码',
        icon: 'none'
      })
      return false;
    }
    if (that.data.roomnumber == "" || that.data.roomnumber == null) {
      wx.showToast({
        title: '请选择楼栋房号',
        icon: 'none'
      })
      return false;
    }

    wx.showLoading({
      title: '请稍等',
    });
    

    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/insertUser', //仅为示例，并非真实的接口地址
      data: {
        //region: that.data.region,
        openid: that.data.openid,
        username: that.data.username,
        phone: that.data.phone,
        roomnumber: that.data.roomnumber,
        subjectid: that.data.subjectid
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        if (res.data.status == 1){
          app.globalData.userStatus = 2;//修改全局用户状态
          //页面跳转
          wx.switchTab({
            url: "../../public/home/home",
          })
        }else{
          wx.showToast({
            title: '出错了，错误信息：'+res.data,
          })
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
  getInputValue: function(e){
    var type = e.target.dataset.type;
    this.setData({
      [type]: e.detail.value
    });
  },


  bindMultiPickerChange: function (e) {
    var biuld = parseInt(this.data.multiArray[0][e.detail.value[0]]);//楼栋
    var unit = parseInt(this.data.multiArray[1][e.detail.value[1]]);//单元
    var room = parseInt(this.data.multiArray[2][e.detail.value[2]]);//房间

    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      multiIndex: e.detail.value,
      roomnumber: biuld + "-" + unit + "-" + room
    })
  },

  bindMultiPickerColumnChange: function (e) {
    var that = this;
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value);
    
    if (e.detail.column == 0){
      that.setData({
        build: that.data.multiArray[0][e.detail.value]
      });
      var data = {
        multiArray: that.data.multiArray,
        multiIndex: that.data.multiIndex
      };
      data.multiIndex[e.detail.column] = e.detail.value;

      wx.request({
        url: "https://www.cloplex.com/property/index.php/FuniController/houseList",
        method: "POST",
        data: {
          interfaceid: that.data.interfaceid,
          "build": that.data.multiArray[0][e.detail.value]
        },
        header: {
          'content-type': "application/x-www-form-urlencoded", // 默认值
          'cookie': wx.getStorageSync("sessionid")
        },
        success(res) {
          data.multiArray[1] = res.data.data[0];
          data.multiArray[2] = res.data.data[1];
          that.setData(data);
        }
      })
    } else if (e.detail.column == 1){
      var data = {
        multiArray: that.data.multiArray,
        multiIndex: that.data.multiIndex
      };
      data.multiIndex[e.detail.column] = e.detail.value;

      wx.request({
        url: "https://www.cloplex.com/property/index.php/FuniController/houseList",
        method: "POST",
        data: {
          interfaceid: that.data.interfaceid,
          "build": that.data.build,
          "unit": that.data.multiArray[1][e.detail.value],
        },
        header: {
          'content-type': "application/x-www-form-urlencoded", // 默认值
          'cookie': wx.getStorageSync("sessionid")
        },
        success(res) {
          data.multiArray[2] = res.data.data[0];
          that.setData(data);
        }
      })
    }
  },

  //获取楼栋房号
  getHouseNumber: function(){
    let that = this;
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/FuniController/houseList',
      method: "POST",
      data: {
        interfaceid: that.data.interfaceid,
        "build":"",
        "unit":""
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      success(res) {
        that.setData({
          "multiArray": res.data.data
        })
        
      }
    })
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
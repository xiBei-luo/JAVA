// miniprogram/pages/public/repair/repair.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activeKey: 0,
    checkboxItems: [
      { name: '给水管道', value: '0', checked: true },
      { name: '供暖设备', value: '1' },
      { name: '消防设备', value: '2' },
      { name: '电梯维修', value: '3' },
      { name: '房屋服务', value: '4' },
      { name: '其他', value: '5' }
    ],
    sexs: [
      { num:"0",value:"男",checked:true},
      { num: "1", value: "女", checked: true}
    ],
    date: "2016-09-01",
    files: []
  },

  onChange(event) {
    wx.showToast({
      icon: 'none',
      title: `切换至第${event.detail}项`
    });
  },

  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  },

  checkboxChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value);

    var checkboxItems = this.data.checkboxItems, values = e.detail.value;
    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = checkboxItems[i].value == e.detail.value;
    }

    this.setData({
      checkboxItems: checkboxItems
    });
  },


  chooseImage: function (e) {
    var that = this;
    wx.chooseImage({
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        that.setData({
          files: that.data.files.concat(res.tempFilePaths)
        });
      }
    })
  },
  previewImage: function (e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
              url: '/pages/household/identify/identify'
            })
          } else {
            wx.navigateBack({})
          }
        }
      });
    } else if (2 == app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '业主信息正在审核中，暂时不能缴费！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
    } else if (!app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '出错了，请稍后再试！',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
    }
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
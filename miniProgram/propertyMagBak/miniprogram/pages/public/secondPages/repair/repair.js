// miniprogram/pages/public/repair/repair.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    checkboxItems: [],
    files: [],
    repairaddress: null,
    repaircontent: null,
    repairimg: [],
    repairtype: null,

  },

  //查询单选框数据
  loadData: function () {
    var that = this;
    // 显示加载图标
    wx.showLoading({
      title: '玩命加载中',
    });
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/assetsList', //仅为示例，并非真实的接口地址
      data: {

      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded",
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        var retData = res.data.data;
        console.log(retData);
        var chkArr = [];
        if (retData.length > 0) {
          for (var i = 0; i < retData.length; i++) {
            var tmpretObj  = {
              "name": retData[i].name,
              "value": retData[i].id
            }
            chkArr.push(tmpretObj);
          }
          that.setData({
            checkboxItems: chkArr
          });
        }
      }
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


  checkboxChange: function (e) {
    console.log(e);
    console.log('checkbox发生change事件，携带value值为：', e.detail.value);

    var checkboxItems = this.data.checkboxItems, values = e.detail.value;
    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = checkboxItems[i].value == e.detail.value;
    }

    this.setData({
      checkboxItems: checkboxItems,
      repairtype: e.detail.value
    });
  },


//选择图片
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
        var tempFilePaths = res.tempFilePaths;
        wx.uploadFile({
          url: 'https://www.cloplex.com/property/index.php/RepairController/uploadImage', //仅为示例，非真实的接口地址
          filePath: tempFilePaths[0],
          name: "file",
          header: {
            "Content-Type": "multipart/form-data",
            'cookie': wx.getStorageSync("sessionid")
          },
          formData: {
            "user": "test",
          },
          success: function (res) {
            var imgData = JSON.parse(res.data);
            console.log(imgData.data);
            if (imgData.status == 1){
              that.setData({
                repairimg: that.data.repairimg.concat(imgData.data)
              });
            }
            console.log(that.data.repairimg);
          }
        })

      }
    })
  },
  previewImage: function (e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
    })
  },


  //提交维修单
  submitRepair: function(){

    var that = this;

    wx.showLoading({
      title: '请稍等',
    });
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/insertRepair', //仅为示例，并非真实的接口地址
      data: {
        repairtype: that.data.repairtype,
        repairaddress: that.data.repairaddress,
        repaircontent: that.data.repaircontent,
        repairimg: JSON.stringify(that.data.repairimg)
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

          wx.showToast({
            title: '成功',
            icon: 'success',
            duration: 3000
          });

        } else {
          wx.showToast({
            title: '出错了',
            icon: 'none',
            duration: 2000
          });
        }
      }
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
              url: '/pages/public/firstVisit/firstVisit'
            })
          } else {
            wx.navigateBack({})
          }
        }
      });
    } else if (2 == app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '业主信息正在审核中，暂时不能报修！',
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
    this.loadData();
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
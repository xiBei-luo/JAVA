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
    this.setData({
      [type]: e.detail.value
    });
  },


  checkboxChange: function (e) {
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
        console.log("wx upload res");
        console.log(res);
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        // that.setData({
        //   files: that.data.files.concat(res.tempFilePaths)
        // });
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
            console.log(res.data);
            var imgData = JSON.parse(res.data);
            if (imgData.status == 1){
              that.setData({
                files: that.data.files.concat(tempFilePaths),
                repairimg: that.data.repairimg.concat(imgData.data)
              });
            }else{
              wx.showToast({
                title: '上传图片失败，'+imgData.msg,
                icon: 'none',
                duration: 3000
              })
            }
          },
          fail: function(res){
            wx.showToast({
              title: '请求失败，'+JSON.stringify(res),
              icon: 'none',
              duration: 3000
            })
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

  //长按图片删除
  deleteImage: function(e){
    var that = this;
    var imagesFiles = that.data.files;
    var imagesSubmit = that.data.repairimg;
    var index = e.currentTarget.dataset.index; //获取当前长按图片下标
    wx.showModal({
      title: '系统提醒',
      content: '确定要删除此图片吗？',
      success: function (res) {
        if (res.confirm) {
          imagesFiles.splice(index, 1);
          imagesSubmit.splice(index, 1);
        } else if (res.cancel) {
          return false;
        }
        that.setData({
          files: imagesFiles,
          repairimg: imagesSubmit
        });
      }
    })
  },


  //提交维修单
  submitRepair: function(){
    var that = this;

    if (that.data.repairtype == "" || that.data.repairtype == null) {
      wx.showToast({
        title: '请选择报修类别',
        icon: 'none'
      })
      return false;
    }

    if (that.data.repairaddress == "" || that.data.repairaddress == null) {
      wx.showToast({
        title: '请输入物品损坏地点',
        icon: 'none'
      })
      return false;
    }

    if (that.data.repaircontent == "" || that.data.repaircontent == null) {
      wx.showToast({
        title: '请详细描述下您所遇到的问题',
        icon: 'none'
      })
      return false;
    }
    

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
        if (res.data.status == 1) {
          wx.reLaunch({
            url: '/pages/public/secondPages/repair/successPage',
          })

        } else {
          wx.showToast({
            title: '出错了：错误信息'+JSON.stringify(res),
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
      return;
    } else if (!app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '出错了，未获取到用户状态',
        confirmText: "确定",
        success: function (res) {
          wx.navigateBack({

          });
        }
      });
      return;
    }


    //category    管理员（1）、物业（2）、项目部（3），还是业主（4）
    if (app.globalData.userInfoDesc.category == 2 || app.globalData.userInfoDesc.category == 3) {
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
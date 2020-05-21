// miniprogram/pages/public/repair/repair.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    files: [],
    suggestimg: [],
    content: null,
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


  //选择并上传图片
  chooseImage: function (e) {
    var that = this;
    wx.chooseImage({
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        // that.setData({
        //   files: that.data.files.concat(res.tempFilePaths)
        // });

        //上传图片
        var tempFilePaths = res.tempFilePaths;
        wx.uploadFile({
          url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/RepairController/uploadImage', //仅为示例，非真实的接口地址
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
            if (imgData.status == 1) {
              that.setData({
                files: that.data.files.concat(tempFilePaths),
                suggestimg: that.data.suggestimg.concat(imgData.data)
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
    var imagesSubmit = that.data.suggestimg;
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
          suggestimg: imagesSubmit
        });
      }
    })
  },

  //提交诉求建议
  submitSuggest: function () {
    var that = this;

    if (that.data.content == "" || that.data.content == null) {
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
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/NewsController/insertNews', //仅为示例，并非真实的接口地址
      data: {
        type: 2,//1 公告  2 诉求
        content: that.data.content,
        newsimg: JSON.stringify(that.data.suggestimg)
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

          wx.reLaunch({
            url: '/pages/public/secondPages/suggest/successPage',
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
    } else if (2 == app.globalData.userStatus) {
      wx.showModal({
        title: '提示',
        content: '业主信息正在审核中，暂时不能提起诉求！',
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
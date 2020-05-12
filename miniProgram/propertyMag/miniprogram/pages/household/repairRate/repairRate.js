Page({
  data: {
    value: 5.0,//评分
    files: [],
    repairimg: [],
    dataList: [],//维修信息

  },


  showResult(e) {
    wx.showToast({
      title: `${e.detail.value}星`,
      icon: 'none'
    })
  },
 
  setValue(e) {
    this.setData({
      value: e.detail.value
    })
  },


  //完成评分
  finishRate: function () {
    var that = this;
    wx.showLoading({
      title: '请稍等',
    })
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/updateRepairRead', //仅为示例，并非真实的接口地址
      data: {
        id: that.data.dataList.id,
        estimate: parseInt(that.data.value)
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
            title: '评分成功',
            duration: 1000,
            success: function(){
              setTimeout(function(){
                var t = getCurrentPages()[getCurrentPages().length - 2];
                t.loadInitData();
                wx.navigateBack({

                })
              }, 1000);
            }
          })

        } else {
          wx.showToast({
            title: '出错了',
            icon: 'none'
          })
        }
      }
    })
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
            console.log(res);
            var imgData = JSON.parse(res.data);
            console.log(imgData.data);
            if (imgData.status == 1) {
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

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    var that = this;
    that.setData({
      dataList: JSON.parse(options.dataList)
    });
  },


  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    var t = getCurrentPages()[getCurrentPages().length - 2];
    t.setData({
      offset: 0
    });
  },

})

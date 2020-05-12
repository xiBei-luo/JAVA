// miniprogram/pages/property/thirdPages/suggest/solve/solve.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataList: [],
    files: [],
  },


  //预览图片
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
    var that = this;


    var contextUrl = "https://www.cloplex.com";
    var parentData = JSON.parse(options.dataList);
    var parentDataImgTmp = JSON.parse(parentData.repairimg);
    var parentDataImg = [];

    for (var i = 0; i < parentDataImgTmp.length; i++) {
      if (parentDataImgTmp[i]){
        var absolutPathStr = parentDataImgTmp[i].substring(13);

        var imgPath = contextUrl + absolutPathStr;

        parentDataImg.push(imgPath);
      }
      
    }

    that.setData({
      dataList: parentData,
      files: parentDataImg
    });
  },


  //确认完成维修
  finishRepair: function(){
    var that = this;
    wx.showLoading({
      title: '请稍等',
    })
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/RepairController/updateRepairRead', //仅为示例，并非真实的接口地址
      data: {
        id: that.data.dataList.id,
        completime: 1
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
            title: '维修成功',
            duration: 1000,
            success: function () {
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
            title: '出错了,错误信息：'+res.msg,
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
    var t = getCurrentPages()[getCurrentPages().length - 2];
    t.setData({
      offset: 0
    });
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
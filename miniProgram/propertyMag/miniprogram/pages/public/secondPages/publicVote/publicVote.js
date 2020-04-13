// miniprogram/pages/public/secondPages/publicVote/publicVote.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

    shortMsgCheckbox: [
      { name: '同意', value: '1' },
      { name: '不同意', value: '0' }
    ],
  },

  //复选框发生变化
  checkboxChange: function (e) {
    var targetChk = e.currentTarget.dataset.type;
    console.log(e.currentTarget.dataset.type);
    console.log(targetChk + '  发生change事件，携带value值为：', e.detail.value);

    var checkboxItems = this.data[targetChk], values = e.detail.value;
    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = checkboxItems[i].value == e.detail.value;
    }

    this.setData({
      [targetChk]: checkboxItems
    });
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
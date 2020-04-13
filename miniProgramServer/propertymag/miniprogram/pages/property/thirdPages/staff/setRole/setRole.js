// miniprogram/pages/systemMag/powMag/powerMag.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activeKey: 0,
    inputShowed: false,
    inputVal: "",
    checkboxItems_role: [
      { name: '小区住户', value: '0' },
      { name: '物业公司人员', value: '1' },
      { name: '项目部人员', value: '2' },
      { name: '第三方人员', value: '3' }
    ],
  },



  //复选框
  checkboxChange: function (e) {
    var targetObj = e.target.dataset.obj;
    //console.log(e.target.dataset.obj);
    //console.log('checkbox发生change事件，携带value值为：', e.detail.value);

    var checkboxItems = this.data[targetObj], values = e.detail.value;


    for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
      checkboxItems[i].checked = false;

      for (var j = 0, lenJ = values.length; j < lenJ; ++j) {
        if (checkboxItems[i].value == values[j]) {
          checkboxItems[i].checked = true;
          break;
        }
      }
    }

    this.setData({
      [targetObj]: checkboxItems
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
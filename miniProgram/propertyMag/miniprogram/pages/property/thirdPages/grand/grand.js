// miniprogram/pages/systemMag/powMag/powerMag.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activeKey: 0,
    inputShowed: false,
    inputVal: "",
    checkboxItems_hoseholder: [
      { name: '家庭成员', value: '0' },
      { name: '缴费记录', value: '1' },
      { name: '报修进度', value: '2' },
      { name: '投票历史', value: '3' },
      { name: '联系物业', value: '4' }
    ],
    checkboxItems_user_center: [
      { name: '入住审核', value: '0' },
      { name: '住户管理', value: '1' },
      { name: '第三方人员管理', value: '2' },
      { name: '员工管理', value: '3' },
      { name: '设备设施管理', value: '4' }
    ],
    checkboxItems_pay_center: [
      { name: '缴费中心', value: '0' }
    ],
    checkboxItems_msg_center: [
      { name: '消息发布', value: '0' },
      { name: '诉求处理', value: '1' }
    ],
    checkboxItems_repair_center: [
      { name: '维修订单', value: '0' }
    ],
    checkboxItems_system_center: [
      { name: '角色管理', value: '0', },
      { name: '权限管理', value: '1' },
      { name: '系统参数', value: '2' }
    ]
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
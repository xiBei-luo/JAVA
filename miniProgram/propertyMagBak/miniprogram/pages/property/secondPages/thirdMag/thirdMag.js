//var base64 = require("../images/base64");
Page({
  data: {
    inputShowed: false,
    inputVal: ""
  },
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
  },


  onLoad: function () {
    this.setData({
      //icon: base64.icon20,
      slideButtons: [{
        text: '角色设置',
        src: '/page/weui/cell/icon_love.svg', // icon的路径
      }, {
        text: '单独授权',
        extClass: 'test',
        src: '/page/weui/cell/icon_star.svg', // icon的路径
      }, {
        type: 'warn',
        text: '删除',
        extClass: 'test',
        src: '/page/weui/cell/icon_del.svg', // icon的路径
      }],
    });
  },

  
  slideButtonTap(e) {
    var operationIndex = e.detail.index;
    if (0 == operationIndex) {
      wx.navigateTo({
        url: '/pages/property/thirdPages/setRole/setRole',
      })
    } else if (1 == operationIndex){
      wx.navigateTo({
        url: '/pages/property/thirdPages/grand/grand',
      })
    } else if (2 == operationIndex) {
      wx.showModal({
        title: '提示',
        content: '确认删除第三方人员【张三三】吗？',
        confirmText: "确认删除",
        cancelText: "放弃删除",
        success: function (res) {
          console.log(res);
          if (res.confirm) {
            console.log('用户点击确认删除')
          } else {
            console.log('用户点击放弃删除')
          }
        }
      });
    }

   
  }
});
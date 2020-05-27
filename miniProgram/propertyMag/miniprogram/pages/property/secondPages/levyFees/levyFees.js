// miniprogram/pages/household/pay/pay.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    inputValMin: null,//查询条件最小值
    inputValMax:null,//查询条件最大值
    checkboxItems: [],
    checkedItem: [],//选中的item
    isCheckAll: false,//是否全选
  },

  //input监控输入
  inputTyping: function (e) {
    var targetObj = e.currentTarget.dataset.target;
    //console.log(targetObj);

    var that = this;

    if(1 == targetObj){
      that.setData({
        inputValMin: e.detail.value
      });
    }else if(2 == targetObj){
      that.setData({
        inputValMax: e.detail.value
      });
    }
    // if(that.data.inputValMin && that.data.inputValMax){
    //   that.loadInitData();
    // }

  },

  checkboxChange: function (e) {
      console.log('checkbox发生change事件，携带value值为：', e.detail.value);
      var checkboxItems = this.data.checkboxItems, values = e.detail.value;
      for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
          checkboxItems[i].checked = false;
          for (var j = 0, lenJ = values.length; j < lenJ; ++j) {
              if(checkboxItems[i].roomnumber == values[j]){
                  checkboxItems[i].checked = true;
                  break;
              }
          }
      }
      this.setData({
          checkboxItems: checkboxItems,
          checkedItem: values
      });
  },
  //全选
  checkAll: function(e){
    console.log(e.detail.value);
    if (e.detail.value =='false') {
      //全选
      var checkboxItems = this.data.checkboxItems;
      var checkedItem = [];
      for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
          checkboxItems[i].checked = true;
          checkedItem.push(checkboxItems[i].roomnumber);
      }
      console.log(checkedItem);
      this.setData({
        isCheckAll : true,
        checkboxItems: checkboxItems,
        checkedItem: checkedItem
      })
    }else{
      //取消全选
      var checkboxItems = this.data.checkboxItems
      for (var i = 0, lenI = checkboxItems.length; i < lenI; ++i) {
          checkboxItems[i].checked = false;
      }
      this.setData({
        isCheckAll : false,
        checkboxItems: checkboxItems,
        checkedItem: []
      })
    }
  },

  //查看详情
  gotoViewDetails: function(e){
    var that = this;
    var dataList = e.currentTarget.dataset.datalist;

    wx.navigateTo({
      url: "/pages/household/payDetails/payDetails?dataList=" + JSON.stringify(dataList),
    })
  },

  //催缴物业费
  f_levyFee:function(){
    var that = this;
    var paramArr = [];
    var checkboxItems = that.data.checkboxItems;
    var checkedItem = that.data.checkedItem;

    for(var i = 0;i<checkboxItems.length;i++){
      for(var j = 0;j<checkedItem.length;j++){
        if(checkboxItems[i].roomnumber == checkedItem[j]){
          var tmpObj = {
            roomnumber: checkboxItems[i].roomnumber,
            money:checkboxItems[i].money
          };
          paramArr.push(tmpObj);
        }
      }
    }
    console.log(paramArr);

    if(paramArr.length <= 0){
      wx.showToast({
        title: '请勾选催费业主',
        duration: 2000,
        icon: 'none'
      })
      return;
    }

    //调接口
    var that = this;
    wx.showLoading({
      title: '请稍等',
    })
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/FuniController/sendFeesNews', //仅为示例，并非真实的接口地址
      data: {
        userarray: JSON.stringify(paramArr)
      },
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success(res) {
        console.log(res);
        wx.hideLoading();//关闭遮罩
        if (res.data.status == 1) {
          wx.showToast({
            title: '催费成功',
            duration: 2000,
            success: function () {
              setTimeout(function () {
                that.setData({
                  checkedItem: []
                });
                that.loadInitData()
              }, 2000) //延迟时间
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
  
  /**
   * 加载初始数据,有时候为了提升页面打开速度，会将所有数据合并到一个接口中返回，然后列表中的第二页数据开始，使用其它接口返回，即分页获取数据时，仅获取下一页的数据。（这里仅做示例，因为每一页数据都取一样的。在实际开发中可以考虑这样分开。）
   */
  loadInitData: function () {
    var that = this
    
    wx.showLoading({
      //title: tips,
      title:"加载中"
    })
    // 刷新时，清空dataArray，防止新数据与原数据冲突
    that.setData({
      checkboxItems: []
    })

    var reqParams = {
      begin: that.data.inputValMin ? that.data.inputValMin:'',
      end: that.data.inputValMax ? that.data.inputValMax:''
    };

    // 请封装自己的网络请求接口，这里作为示例就直接使用了wx.request.
    wx.request({
      url: app.globalData.HTTP_REQUEST_URL+'/property/index.php/FuniController/subjectFindFees',
      data: reqParams,
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      method: "POST",
      success: function (res) {
        wx.hideLoading();
        var data = res.data; // 接口相应的json数据
        if(data.status == 1){
          console.log(data.data);
          if(data.data && data.data.length && data.data.length > 0){
            that.setData({
              checkboxItems: data.data
            })
          }else{
            wx.showToast({
              title: '暂无数据',
              icon: 'none',
              duration: 2000
            })
          }
        }else{
          wx.showToast({
            title: '出错了',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 加载页面初始化时需要的数据
    setTimeout(function () {
      that.loadInitData();
    }, 1000) //延迟时间 这里是1秒
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
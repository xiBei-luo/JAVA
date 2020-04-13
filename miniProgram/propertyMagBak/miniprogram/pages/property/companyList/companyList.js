
Page({
  data: {
    region: "",
    companyid: "",
    companyname: "",
    inputShowed: false,
    inputVal: "",
    companyList: [],
    offset:0,
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

  //input实时输入
  inputTyping: function (e) {
    var that = this;
    wx.showLoading({
      title: '请稍等',
    });
    that.setData({
      inputVal: e.detail.value
    });
    console.log("关键字：" + this.data.inputVal);
    that.loadData();
  },


  //选中项目部,
  selectCompany: function (e) {
    var companyid = e.currentTarget.dataset.targetindex;
    var companyname = e.currentTarget.dataset.targettxt;
    console.log(companyid);
    console.log(companyname);

    var pages = getCurrentPages();
    var currPage = pages[pages.length - 1];   //当前页面
    var prevPage = pages[pages.length - 2];  //上一个页面
    //直接调用上一个页面对象的setData()方法，把数据存到上一个页面中去
    prevPage.setData({
      companyid: companyid,
      companyname: companyname
    });

    wx.navigateBack({

    });
  },

  //加载数据
  loadData: function(){
    var that = this;
    // 页数+1
    that.data.offset = that.data.offset + 1;
    that.setData({
      offset: that.data.offset
    });
    // 显示加载图标
    wx.showLoading({
      title: '玩命加载中',
    })
    console.log("pages," + that.data.offset);
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/selectCompany', //仅为示例，并非真实的接口地址
      // data: {
      //   region: this.data.region,
      //   searchKey: this.data.inputVal
      // },
      data: {
        region: "成都",
        searchKey: that.data.inputVal,
        offset: that.data.offset
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩
        if (that.data.inputVal || that.data.region) {
          that.setData({
            companyList: res.data.data
          })
        } else{
          if (!res.data.data) {
            // 显示加载图标
            wx.showToast({
              title: '到底了',
              icon: "none",
              duration: 1000
            })
          } else {
            var retList = that.data.companyList.concat(res.data.data);
            console.log(res.data.data);
            that.setData({
              companyList: retList
            })
          }
        }

      }
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    
    if (options.region){
      this.setData({
        region: (options.region).replace(/,/g, '')
      });
    }else{
      this.setData({
        region: ""
      });
    }
    that.loadData();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    var that = this;

    this.loadData();
  },



});
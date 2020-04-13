

Page({
  data: {
    region: "",
    subjectid: "",
    subjectname: "",
    companyid: "",
    inputShowed: false,
    inputVal: "",
    villageList: [],
    offset: 0,
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

    this.loadData();
  },

  //加载数据
  loadData: function(){
    var that = this;
    // 页数+1
    that.data.offset = that.data.offset+1;
    that.setData({
      offset: that.data.offset
    });
    // 显示加载图标
    wx.showLoading({
      title: '玩命加载中',
    })
    var params = {
      region: "成都",
      searchKey: that.data.inputVal,
      offset: that.data.offset
    };

    if (this.data.companyid) {
      params = {
        id: this.data.companyid,
        searchKey: that.data.inputVal,
        offset: that.data.offset
      };
    }

    console.log("pages,"+that.data.offset);
    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/getSubjectList', //仅为示例，并非真实的接口地址
      // data: {
      //   region: this.data.region,
      //   searchKey: this.data.inputVal
      // },
      data: params,
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success(res) {
        console.log(res.data.data);
        wx.hideLoading();//关闭遮罩

        if (that.data.inputVal || that.data.companyid){
          that.setData({
            villageList: res.data.data
          })
        }else{
          if (!res.data.data) {
            // 显示加载图标
            wx.showToast({
              title: '到底了',
              icon: "none",
              duration: 1000
            })
          } else {
            var retList = that.data.villageList.concat(res.data.data);
            that.setData({
              villageList: retList
            })
          }
        }

        

        
      }
    })
  },


  //选中项目部,
  selectVillage: function(e){
    var subjectid = e.currentTarget.dataset.targetindex;
    var subjectname = e.currentTarget.dataset.targettxt;
    console.log(subjectid);
    console.log(subjectname);
    
    var pages = getCurrentPages();
    var currPage = pages[pages.length - 1];   //当前页面
    var prevPage = pages[pages.length - 2];  //上一个页面
    //直接调用上一个页面对象的setData()方法，把数据存到上一个页面中去
    prevPage.setData({
      subjectid: subjectid,
      subjectname: subjectname
    });

    wx.navigateBack({
      
    });
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log(options);
    this.setData({
      region: (options.region).replace(/,/g, ''),//去除省市区之间的逗号
      companyid: options.companyid,
    });
    

    this.loadData();
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    var that = this;
    // 显示加载图标
    wx.showLoading({
      title: '玩命加载中',
    })
    
    this.loadData();
  },




});
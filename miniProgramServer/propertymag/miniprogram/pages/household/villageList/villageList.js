

Page({
  data: {
    region: "",
    subjectid: "",
    subjectname: "",
    inputShowed: false,
    inputVal: "",
    villageList: []
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


    wx.request({
      url: 'https://www.cloplex.com/property/index.php/IndexController/getSubjectList', //仅为示例，并非真实的接口地址
      // data: {
      //   region: this.data.region,
      //   searchKey: this.data.inputVal
      // },
      data: {
        region: "成都",
        searchKey: that.data.inputVal
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success(res) {
        wx.hideLoading();//关闭遮罩

        console.log(res.data.data);

        that.setData({
          villageList: res.data.data
        })


       
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
    console.log(options);
    this.setData({
      region: (options.region).replace(/,/g, '')
    })
    
  },



});
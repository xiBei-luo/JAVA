class loadDataAndPage{


  constructor(pageObj,requestURL,RequestMethod){
    this._pageObj = pageObj;//当前页面对象
    this._paramObj = {};//参数
    this._requestURL = requestURL;//请求地址(不能为空)
    this._RequestMethod = RequestMethod;//请求方式(不能为空)
  }

  addParamObj(paramObj){
    this._paramObj = paramObj;
  }


  loadInitData(callbackMethod){
    console.log("in");
    wx.request({
      url: this._requestURL,
      data: this._paramObj,
      method: this._RequestMethod,
      header: {
        'content-type': "application/x-www-form-urlencoded", // 默认值
        'cookie': wx.getStorageSync("sessionid")
      },
      success: function (res) {
        callbackMethod(res);
  
  
        wx.hideLoading();
        var data = res.data; // 接口相应的json数据
        if(data.status == 1){
          var articles = data.data; // 接口中的data对应了一个数组，这里取名为 articles
          if(articles && articles.length && articles.length > 0){
            var totalDataCount = articles.length;
            console.log(articles);
            console.log("totalDataCount:"+totalDataCount);
            pageObj.setData({
              ["dataArray["+currentPage+"]"]: articles,
              currentPage: currentPage,
              totalDataCount: totalDataCount,
              showMoreBtn: true
            })
          }else{
            pageObj.setData({
              showMoreBtn: false
            })
            wx.showToast({
              title: '暂无数据',
              icon: 'none',
              duration: 2000
            })
          }
        }else{
          pageObj.setData({
            showMoreBtn: false
          })
          wx.showToast({
            title: '出错了',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  }


}




//转化成小程序模板语言 这一步非常重要 不然无法正确调用
export{loadDataAndPage}

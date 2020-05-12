//app.js
App({
  //全局参数（可以整个应用程序共享）
  globalData: {
    //userInfo: null,
    userStatus: null,
    openid: null,
    userInfoDesc: null,
    userNewsList: null,
  },

  onLaunch: function () {

    var that = this;
   
    that.globalData = {}


    //用户登陆，获取code发送至服务端获取openid
    wx.login({
      success: res => {
        // 登录注册接口
        if (res.code) {
          // 调用服务端登录接口，发送 res.code 到服务器端换取 openId, sessionKey, unionId并存入数据库中
          //发送请求
          wx.request({
            url: 'https://www.cloplex.com/property/index.php/IndexController/getWxAppid', //仅为示例，并非真实的接口地址
            //url: 'http://localhost:8088/GetOpenid/getOpenid',
            data: {
              code: res.code
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            method: "GET",
            success(res) {
              console.log(res.data);
              var status = res.data.status;//status表示，0是获取openid失败，1是成功并返回用户信息，2是用户未审核，3是新用户
              that.globalData.userStatus = status; 
              that.globalData.userInfoDesc = res.data.data;


              wx.removeStorageSync('sessionid') //必须先清除，否则res.header['Set-Cookie']会报错
              // 注意：Set-Cookie（开发者工具中调试全部小写）（远程调试和线上首字母大写）
              wx.setStorageSync("sessionid", res.header["Set-Cookie"]);

              //请求成功之后，把openid放到储存里面
              wx.setStorage({
                key: 'openid',
                data: res.data.data
              })
            }
          })

        } else {
          console.log('登录失败！' + res.errMsg)
        }
      },

      fail:res=>{
        console.log("未授权！");
      }

    });



    


  }
})

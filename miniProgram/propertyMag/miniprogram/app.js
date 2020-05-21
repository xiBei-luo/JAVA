//app.js
App({
  //全局参数（可以整个应用程序共享）
  globalData: {
    HTTP_REQUEST_URL: "https://www.cloplex.com",//域名
    //userInfo: null,
    userStatus: null,
    openid: null,
    userInfoDesc: null,
    //userNewsList: null,
    IsAuthorization: false, // 是否绑定（是否授权）
    imgRelativePathLen: 20,  //访问服务器图片相对路径，服务器保存绝对路径["/var/www/html/public/uploads/property/9245f8b201b97c84fe5fa2966b1051c5.jpg"]
  },

  //监听全局变量

watch: function (method) {
  var obj = this.globalData
  Object.defineProperty(obj, 'IsAuthorization', {
    configurable: true,
    enumerable: true,
    set: function (value) {
      this._name = value;
      method(value);
    },
    get: function(){
      return this._name
    }
   })
},

  onLaunch: function () {
    var that = this;
    //用户登陆，获取code发送至服务端获取openid
    wx.login({
      success: res => {
        // 登录注册接口
        if (res.code) {
          // 调用服务端登录接口，发送 res.code 到服务器端换取 openId, sessionKey, unionId并存入数据库中
          //发送请求
          wx.request({
            url: 'https://www.cloplex.com/property/index.php/IndexController/getWxAppid', //仅为示例，并非真实的接口地址
            data: {
              code: res.code
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            method: "GET",
            success(res) {
              if(res.status == 0){
                wx.showToast({
                  title: '获取openid失败：'+res.msg,
                  icon: 'none',
                  duration: 4000
                })
              }else{
                var status = res.data.status;//status表示，0是获取openid失败，1是成功并返回用户信息，2是用户未审核，3是新用户
                that.globalData.userStatus = status; 
                that.globalData.userInfoDesc = res.data.data;
                console.log(res.data);
                wx.removeStorageSync('sessionid') //必须先清除，否则res.header['Set-Cookie']会报错
                // 注意：Set-Cookie（开发者工具中调试全部小写）（远程调试和线上首字母大写）
                wx.setStorageSync("sessionid", res.header["Set-Cookie"]);
                //请求成功之后，把openid放到储存里面
                wx.setStorage({
                  key: 'openid',
                  data: res.data.data
                })
                //获取openid等操作结束之后
                that.globalData.IsAuthorization = true;
              }
            },
            fail:res=>{
              console.log("请求openid接口失败");
              console.log(res);
              wx.showToast({
                title: '请求openid接口失败：'+JSON.stringify(res),
                icon: 'none',
                duration: 4000
              })
            }
          })
        } else {
          console.log('登录失败！' + res.errMsg);
          wx.showToast({
            title: '获取code值失败：'+JSON.stringify(res),
            icon: 'none',
            duration: 4000
          })
        }
      },

      fail:res=>{
        console.log("未授权！");
        wx.showToast({
          title: '登陆失败,请退出重新进入小程序：'+JSON.stringify(res),
          icon: 'none',
          duration: 4000
        })
      }

    });



    


  }
})

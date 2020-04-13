//app.js
App({
  //全局参数（可以整个应用程序共享）
  globalData: {
    userInfo: null,
    userStatus: null,
    openid: null
  },

  onLaunch: function () {
    var that = this;
    
    if (!wx.cloud) {
      console.error('请使用 2.2.3 或以上的基础库以使用云能力')
    } else {
      wx.cloud.init({
        // env 参数说明：
        //   env 参数决定接下来小程序发起的云开发调用（wx.cloud.xxx）会默认请求到哪个云环境的资源
        //   此处请填入环境 ID, 环境 ID 可打开云控制台查看
        //   如不填则使用默认环境（第一个创建的环境）
        // env: 'my-env-id',
        traceUser: true,
      })
    }
    that.globalData = {}

    //用户登陆，获取code发送至服务端获取openid
    wx.login({
      success: res => {
        // 登录注册接口
        if (res.code) {
          // console.log(res.code);
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
              console.log(res.header["Set-Cookie"]);
              console.log(res.data);
              var status = res.data.status;//status表示，0是获取openid失败，1是成功并返回用户信息，2是用户未审核，3是新用户
              console.log(status);
              that.globalData.userStatus = status;


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
      }
    });



    //获取用户信息（头像昵称、地理位置等）
    wx.getSetting({
      success: res => {
        // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
        if (res.authSetting['scope.userInfo']) {
          //1.用户昵称头像等信息
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              //console.log(res);
              that.globalData.userInfo = res.userInfo
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          });
          //2.用户地理位置
          wx.getLocation({
            success: res => {
              //console.log(res);
            }
          });
          //console.log('已经授权')
        }else{
          //未授权，跳转至授权页面
          wx.redirectTo({
            url: 'pages/public/authorize/authorize',//授权页面
          })
        }
      }
    });


  }
})

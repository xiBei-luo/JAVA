package com.imooc.concurrent.ssodemo.controller;

import com.imooc.concurrent.ssodemo.model.User;
import com.imooc.concurrent.ssodemo.util.LoginCheck;

/**
 * Created by Luowenlv on 2018/11/22,11:04
 *
 * SSO单点登陆_统一登陆接口(controller)
 */
public class LoginInterface {
    private User user = new User("admin","123456");//获取用户的输入
    public LoginInterface(){
        boolean isLogin = LoginCheck.LoginCheck(user);
        if(isLogin){

        }
    }

    public LoginInterface(User user) {

    }
}

package com.imooc.concurrent.ssodemo.util;

import com.imooc.concurrent.ssodemo.model.User;

/**
 * Created by Luowenlv on 2018/11/22,11:11
 */
public class LoginCheck {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "123456";

    public static boolean LoginCheck(User user) {
        if (user.getUsername().equals(USERNAME) && user.getPassword().equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }

    }
}

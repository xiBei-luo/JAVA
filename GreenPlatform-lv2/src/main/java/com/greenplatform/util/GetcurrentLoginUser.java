package com.greenplatform.util;

import com.greenplatform.model.PlateUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取当前登陆系统的用户
 */
public class GetcurrentLoginUser {
    public static PlateUser getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        PlateUser currentLoginUser = (PlateUser)request.getSession().getAttribute("loginUser");
        return currentLoginUser;
    }
}

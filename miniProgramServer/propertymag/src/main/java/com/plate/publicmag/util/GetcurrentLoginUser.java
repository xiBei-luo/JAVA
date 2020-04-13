package com.plate.publicmag.util;

import com.plate.publicmag.model.PublicUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取当前登陆系统的用户
 */
public class GetcurrentLoginUser {
    public static PublicUser getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        PublicUser currentLoginUser = (PublicUser)request.getSession().getAttribute("loginUser");
        return currentLoginUser;
    }
}

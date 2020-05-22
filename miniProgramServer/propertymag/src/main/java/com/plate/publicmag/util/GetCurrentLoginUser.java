package com.plate.publicmag.util;

import com.plate.publicmag.model.TSystemAdmin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取当前登陆系统的用户
 */
public class GetCurrentLoginUser {
    public static TSystemAdmin getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TSystemAdmin currentLoginUser = (TSystemAdmin)request.getSession().getAttribute("curLoginUser");
        return currentLoginUser;
    }
}

package com.greenplatform.service;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {
    ReturnModel checkLogin(PlateUser plateUser, HttpSession session);

    ReturnModel doRegister(PlateUser plateUser, HttpSession session);

    boolean checkUser(String type, String value);
}

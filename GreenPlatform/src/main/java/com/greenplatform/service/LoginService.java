package com.greenplatform.service;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LoginService {
    ReturnModel checkLogin(PlateUser plateUser, HttpSession session);

    ReturnModel doRegister(String jsonObject, HttpSession session);

    boolean checkUser(String type, String value);

    ReturnModel checkSmsCode(Map<String,String> hashMap, HttpSession session);

    ReturnModel retWebUserPassowrd(String jsonObject, HttpSession session);

    ReturnModel loginByPhone(String jsonObject, HttpSession session);
}

package com.greenplatform.controller;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    LoginService loginService;


    @PostMapping(value = "/login")
    public ReturnModel login(PlateUser plateUser, HttpSession session){
        ReturnModel returnModel = loginService.checkLogin(plateUser,session);
        System.out.println(returnModel);
        return returnModel;
    }

    @PostMapping(value = "/register")
    public ReturnModel register(PlateUser plateUser, HttpSession session){
        System.out.println("in register");
        ReturnModel returnModel = loginService.doRegister(plateUser,session);
        System.out.println(returnModel);
        return returnModel;
    }
}

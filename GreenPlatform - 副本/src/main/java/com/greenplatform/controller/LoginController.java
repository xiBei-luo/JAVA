package com.greenplatform.controller;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.baseModel.ReturnModel;
import com.greenplatform.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    Loginservice loginservice;

    @RequestMapping("/index")
    public String index(Model model){
        PlateUser plateUser = new PlateUser();
        plateUser.setcUserid(2);
        ReturnModel returnModel = loginservice.checkLogin(plateUser);
        model.addAttribute(returnModel.getData());
        return "index";
    }
}

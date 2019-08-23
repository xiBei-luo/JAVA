package com.greenplatform.controller;

import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 未登录访问主页
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    WebService webService;


    @GetMapping("/")
    public String gotoIndex(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "index";
    }
}

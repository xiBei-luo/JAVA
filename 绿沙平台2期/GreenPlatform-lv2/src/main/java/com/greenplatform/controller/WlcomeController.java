package com.greenplatform.controller;

import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * 未登录访问主页
 */
@Controller
@RequestMapping("/")
public class WlcomeController {
    @Autowired
    WebService webService;


    @GetMapping("/")
    public String gotoIndex(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "welcome/index";
    }

    @GetMapping(value = "/home")
    public String home(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "welcome/home";
    }
    @GetMapping(value = "/doLike")
    public String doLike(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "welcome/doLike";
    }
    @GetMapping(value = "/nlRank")
    public String nlRank(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "welcome/nlRank";
    }
    @GetMapping(value = "/shop")
    public String shop(Model model){
        ReturnModel returnModel = webService.selectWelcomePageInfo();
        model.addAttribute("loginuserHome", returnModel.getObject());
        return "welcome/shop";
    }
    @GetMapping(value = "/myAccount")
    public String myAccount(){
        return "welcome/myAccount";
    }
}

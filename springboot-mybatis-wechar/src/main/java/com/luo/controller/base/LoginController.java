package com.luo.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luowenlv on 2019/5/7,11:21
 */
@Controller
@RequestMapping(value = "/loginPlate")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String loginname,String password){
        System.out.print(loginname+"---"+password);
        return "/plate/index";
    }
}

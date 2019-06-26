package com.greenplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Luowenlv on 2019/5/15,14:44
 * 基础控制
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController {

    @GetMapping(value = "/index")
    public String index() {
        return "plate/index";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "login/register";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login/login";
    }
}

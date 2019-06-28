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
    //公用
    @GetMapping(value = "/login")
    public String login() {
        return "login/login";
    }
    @GetMapping(value = "/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login/login";
    }

    //后台
    //后台-业务功能
    @GetMapping(value = "/index")
    public String index() {
        return "plate/index";
    }
    @GetMapping(value = "/yhgl")
    public String yhgl(){
        return "plate/yhgl/main";
    }
    @GetMapping(value = "/yhgl/edit")
    public String yhglEdit(){
        return "plate/yhgl/edit";
    }
    @GetMapping(value = "/rwgl")
    public String rwgl(){
        return "plate/rwgl/main";
    }
    @GetMapping(value = "/nlgl")
    public String nlgl(){
        return "plate/nlgl/main";
    }
    @GetMapping(value = "/spgl")
    public String spgl(){
        return "plate/spgl/main";
    }
    @GetMapping(value = "/spgl/edit")
    public String spglEdit(){
        return "plate/spgl/edit";
    }
    @GetMapping(value = "/stgl")
    public String stgl(){
        return "plate/stgl/main";
    }
    @GetMapping(value = "/zhsjgl")
    public String zhsjgl(){
        return "plate/zhsjgl/main";
    }
    //后台-系统配置
    @GetMapping(value = "/ywjcdm")
    public String ywjcdm(){
        return "plate/ywjcdm/main";
    }
    @GetMapping(value = "/ywjcdm/edit")
    public String ywjcdmEdit(){
        return "plate/ywjcdm/edit";
    }


    //网站
    @GetMapping(value = "/register")
    public String register() {
        return "login/register";
    }
    @GetMapping(value = "/history")
    public String history(String type){
        return "web/history";
    }
    @GetMapping(value = "/certification")
    public String certification(String type){
        return "web/certification";
    }



















}

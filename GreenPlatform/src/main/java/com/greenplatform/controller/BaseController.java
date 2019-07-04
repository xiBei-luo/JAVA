package com.greenplatform.controller;

import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Luowenlv on 2019/5/15,14:44
 * 基础控制
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController {
    @Autowired
    PlateService plateService;


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
    /**
     * 查询登陆用户权限
     * @param model
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpSession session,Model model) {
        ReturnModel returnModel = plateService.selectLoginuserYwqx();
        System.out.println(returnModel.getObject());
        if (0 != returnModel.getFlag()){
            session.removeAttribute("loginUser");
            return "login/login";
        }else{
            model.addAttribute("loginuserYwqxMap",returnModel.getObject());
            return "plate/index";
        }
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
    @GetMapping(value = "/plateYhgl")
    public String plateYhgl(){
        return "plate/plateYhgl/main";
    }
    @GetMapping(value = "/plateYhgl/edit")
    public String plateYhglEdit(){
        return "plate/plateYhgl/edit";
    }
    @GetMapping(value = "/qxgl")
    public String qxgl(){
        return "plate/qxgl/main";
    }
    @GetMapping(value = "/qxgl/edit")
    public String qxglEdit(){
        return "plate/qxgl/edit";
    }
    @GetMapping(value = "/xtcssz")
    public String xtcssz(){
        return "plate/xtcssz/main";
    }
    @GetMapping(value = "/xtcssz/edit")
    public String xtcsszEdit(){
        return "plate/xtcssz/edit";
    }
    @GetMapping(value = "/yypz")
    public String yypz(){
        return "plate/yypz/main";
    }
    @GetMapping(value = "/yypz/edit")
    public String yypzEdit(){
        return "plate/yypz/edit";
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

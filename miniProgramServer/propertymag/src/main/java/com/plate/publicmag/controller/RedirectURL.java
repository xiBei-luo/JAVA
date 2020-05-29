package com.plate.publicmag.controller;

import com.plate.publicmag.service.SystemMagService;
import com.plate.publicmag.util.GetCurrentLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/RedirectURL")
public class RedirectURL {
    @Autowired
    SystemMagService systemMagService;

    @RequestMapping("/gotoHomePage")
    public String gotoHomePage(HttpSession session, Model model){
        model.addAttribute("curLoginUser",GetCurrentLoginUser.getCurrentUser());//当前登陆用户
        model.addAttribute("userMenuList",systemMagService.selectMenuByLoginUser(session).getData());//用户权限
        return "/index";
    }



    //登陆注册
    @RequestMapping("/gotoLogin")
    public String login(){
        return "/loginPage/login";
    }

    //综合查询
    @RequestMapping("/gotoLogQuery")
    public String gotoLogQuery(){
        return "/comprehensiveQuery/query_log";
    }

    //系统管理
    @RequestMapping("/gotoUserMag")
    public String gotoUserMag(){
        return "/systemMag/user_mag";
    }

    @RequestMapping("/gotoRoleMag")
    public String gotoRoleMag(){
        return "/systemMag/role_mag";
    }

    @RequestMapping("/gotoMenuMag")
    public String gotoMenuMag(){
        return "/systemMag/menu_mag";
    }

    @RequestMapping("/gotoCodeMag")
    public String gotoCodeMag(){
        return "/systemMag/code_mag";
    }
}

package com.plate.publicmag.controller;

import com.plate.publicmag.service.SystemMagService;
import com.plate.publicmag.util.GetCurrentLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/gotoLogQuery")
    public String gotoLogQuery(){
        return "/comprehensiveQuery/query_log";
    }

    @RequestMapping("/user_mag")
    public String gotoUserMag(){
        return "user_mag";
    }

    @RequestMapping("/role_mag")
    public String gotoRoleMag(){
        return "role_mag";
    }
}

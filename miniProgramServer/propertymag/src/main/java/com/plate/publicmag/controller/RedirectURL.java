package com.plate.publicmag.controller;

import com.plate.publicmag.service.SystemMagService;
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

        model.addAttribute("pageMenu",systemMagService.selectMenuByLoginUser(session).getData());
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

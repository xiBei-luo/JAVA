package com.plate.publicmag.controller;

import com.plate.publicmag.dao.PublicUserMapper;
import com.plate.publicmag.model.PublicUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class LoginCOntroller {
    @Autowired
    PublicUserMapper publicUserMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(PublicUser publicUser, HttpSession session, Model model){
        PublicUser publicUser1 = publicUserMapper.selectByPrimaryKey(1);
        session.setAttribute("loginUser",publicUser1);
        model.addAttribute(publicUser1);
        return "index";
    }
}

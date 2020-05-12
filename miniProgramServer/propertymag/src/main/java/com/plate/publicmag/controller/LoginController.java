package com.plate.publicmag.controller;

import com.plate.publicmag.dao.PublicUserMapper;
import com.plate.publicmag.model.PublicUser;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    PublicUserMapper publicUserMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel login(PublicUser publicUser, HttpSession session){
        PublicUser publicUser1 = publicUserMapper.selectByPrimaryKey(1);
        session.setAttribute("loginUser",publicUser1);
        return ReturnModelHandler.success(publicUser1);
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.removeAttribute("loginUser");
        return "login";
    }
}

package com.plate.publicmag.controller;

import com.plate.publicmag.dao.TSystemAdminMapper;
import com.plate.publicmag.model.TSystemAdmin;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.util.GetCurrentLoginUser;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    TSystemAdminMapper tSystemAdminMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel login(TSystemAdmin publicUser, HttpSession session){
        TSystemAdmin systemAdmin = tSystemAdminMapper.selectByPrimaryKey(1);
        session.setAttribute("curLoginUser",systemAdmin);
        return ReturnModelHandler.success(systemAdmin);
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.removeAttribute("curLoginUser");
        return "login";
    }
}

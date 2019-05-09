package com.greenplatform.controller;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/plate")
public class PlateController {

    @Autowired
    PlateService plateService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "plate/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(PlateUser plateUser){
        System.out.println(plateUser);
        ReturnModel returnModel = plateService.checkLogin(plateUser);
        return "plate/index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "plate/register";
    }
    @RequestMapping(value = "/selectUserByEmail", method = RequestMethod.POST)
    @ResponseBody
    public String selectUserByEmail(PlateUser plateUser){
        System.out.println(plateUser);
        ReturnModel returnModel = plateService.selectUserByEmail(plateUser);
        return "returnModel";
    }
    @RequestMapping(value = "/selectUserByLoginname", method = RequestMethod.POST)
    @ResponseBody
    public String selectUserByLoginname(PlateUser plateUser){
        System.out.println(plateUser);
        ReturnModel returnModel = plateService.selectUserByLoginname(plateUser);
        return "returnModel";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(PlateUser plateUser){
        System.out.println(plateUser);
        plateService.insertUser(plateUser);
        return "plate/index";
    }
}

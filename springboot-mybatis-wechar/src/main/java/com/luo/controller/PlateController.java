package com.luo.controller;

import com.luo.model.PlateUser;
import com.luo.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/plate")
public class PlateController {
    /*@Autowired
    ReturnModel returnModel;*/

    @Autowired
    PlateService plateService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "plate/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(PlateUser plateUser){
        System.out.println(plateUser);
        PlateUser plateUser1 = plateService.checkLogin(plateUser);
        System.out.println(plateUser1);
        return "plate/index";
    }
}

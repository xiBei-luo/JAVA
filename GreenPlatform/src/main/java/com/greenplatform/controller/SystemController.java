package com.greenplatform.controller;

import com.greenplatform.model.SystemUser;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController {
    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        ReturnModel returnModel = systemService.selectTGreenSpSpmx(new TGreenSpSpmx());
        model.addAttribute("tGreenSpSpmxList", returnModel.getObject());
        return "system/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel login(SystemUser systemUser){
        System.out.println(systemUser);
        ReturnModel returnModel = systemService.selectSystemuser(systemUser);
        return returnModel;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel register(SystemUser systemUser){
        ReturnModel returnModel = new ReturnModel();
        returnModel = systemService.insertSystemUser(systemUser);
        return returnModel;
    }




}

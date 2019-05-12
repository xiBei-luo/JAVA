package com.greenplatform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/plate")
public class PlateController {

    @Autowired
    PlateService plateService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(PlateUser plateUser, Model model,Integer page) {
        Integer limit = 30;
        if ("".equals(page) || null == page){
            page = 1;
        }
        PageHelper.startPage(page, limit);
        List plateUserList = (List) (plateService.selectPlateuser(plateUser)).getObject();
        PageInfo pageInfo=new PageInfo<>(plateUserList);
        System.out.println(pageInfo);
        model.addAttribute("plateUserList",plateUserList);
        model.addAttribute("pageInfo",pageInfo);
        return "plate/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "plate/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel login(PlateUser plateUser){
        ReturnModel returnModel = plateService.selectPlateuser(plateUser);
        return returnModel;
    }
}

package com.greenplatform.controller;

import com.greenplatform.model.TGreenRwRwmx;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.TGreenZzZjzzmx;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.WebService;
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
@RequestMapping(value = "/web")
public class WebController {
    @Autowired
    WebService systemService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        ReturnModel returnModel = systemService.selectTGreenSpSpmx(new TGreenSpSpmx());
        model.addAttribute("tGreenSpSpmxList", returnModel.getObject());
        return "web/index";
    }

    @RequestMapping(value = "/selectLoginuserAccount",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel selectLoginuserAccount(){
        ReturnModel returnModel = new ReturnModel();
        returnModel = systemService.selectLoginuserAccount();
        return returnModel;
    }

    //种子商店兑换种子
    @RequestMapping(value = "/insertTGreenZzZjzzmx",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel insertTGreenZzZjzzmx(TGreenZzZjzzmx tGreenZzZjzzmx){
        ReturnModel returnModel = new ReturnModel();
        returnModel = systemService.insertTGreenZzZjzzmx(tGreenZzZjzzmx);
        return returnModel;
    }

    //完成每日基础任务
    @RequestMapping(value = "/insertTGreenRwRwmx",method = RequestMethod.POST)
    @ResponseBody
    public ReturnModel insertTGreenRwRwmx(TGreenRwRwmx tGreenRwRwmx){
        ReturnModel returnModel = new ReturnModel();
        returnModel = systemService.insertTGreenRwRwmx(tGreenRwRwmx);
        return returnModel;
    }




}

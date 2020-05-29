package com.plate.publicmag.controller;

import com.plate.publicmag.dao.TSystemAdminMapper;
import com.plate.publicmag.dao.TSystemMenuMapper;
import com.plate.publicmag.model.TSystemMenu;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.service.SystemMagService;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Plate")
public class PlateController {
    @Autowired
    TSystemMenuMapper tSystemMenuMapper;

    @Autowired
    SystemMagService systemMagService;

    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/getMenu",method = RequestMethod.POST)
    @ResponseBody
    public TSystemMenu getMenu(){

        return tSystemMenuMapper.selectByPrimaryKey(1);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllMenu",method = RequestMethod.POST)
    public ReturnModel getAllMenu(){
        return ReturnModelHandler.success(systemMagService.selectAllMenu());
    }
}

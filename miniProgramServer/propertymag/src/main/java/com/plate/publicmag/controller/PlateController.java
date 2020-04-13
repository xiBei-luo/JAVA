package com.plate.publicmag.controller;

import com.plate.publicmag.dao.PublicMenuMapper;
import com.plate.publicmag.model.PublicMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Plate")
public class PlateController {
    @Autowired
    PublicMenuMapper publicMenuMapper;

    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/getMenu",method = RequestMethod.POST)
    @ResponseBody
    public PublicMenu getMenu(){

        return publicMenuMapper.selectByPrimaryKey(1);
    }
}

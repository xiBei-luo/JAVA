package com.luo.controller.plate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/plate")
public class PlateController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "plate/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String loginname,String password){
        return "plate/index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login1(){
        return "plate/index";
    }
}

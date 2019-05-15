package com.greenplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luowenlv on 2019/5/15,14:44
 * 基础控制
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController {

    @RequestMapping(value = "/rwgl",method = RequestMethod.GET)
    public String rwgl(){
        return "plate/rwgl/index";
    }

    @RequestMapping(value = "/nlgl",method = RequestMethod.GET)
    public String nlgl(){
        return "plate/nlgl/index";
    }

    @RequestMapping(value = "/spgl",method = RequestMethod.GET)
    public String spgl(){
        return "plate/spgl/index";
    }

    @RequestMapping(value = "/stgl",method = RequestMethod.GET)
    public String stgl(){
        return "plate/stgl/index";
    }

    @RequestMapping(value = "/zhsjgl",method = RequestMethod.GET)
    public String zhsjgl(){
        return "plate/zhsjgl/index";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "plate/test";
    }
}

package com.greenplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luowenlv on 2019/5/7,11:25
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "system/index";
    }
}

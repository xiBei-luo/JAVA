package com.greenplatform.controller;


import com.alibaba.fastjson.JSON;
import com.greenplatform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/checkForm")
public class CheckFormController {

    @Autowired
    LoginService loginService;


    /**
     * 验证电话号码
     * @param type (0判断不存在返回true，1判断存在返回true)
     * @param cPhone
     * @return
     */
    @PostMapping(value = "/checkPhone")
    public String checkPhone(String type,String cPhone){
        HashMap<String,Boolean> hashMap = new HashMap();

        if ("1".equals(type)){
            hashMap.put("valid",!(loginService.checkUser("phone",cPhone)));
        }else{
            hashMap.put("valid",loginService.checkUser("phone",cPhone));
        }

        System.out.println(hashMap);
        return JSON.toJSONString(hashMap);
    }

    /**
     * 验证用户名
     * @param cLoginname
     * @return
     */
    @PostMapping(value = "/checkLoginname")
    public String checkLoginname(String cLoginname){
        System.out.println("in");
        HashMap<String,Boolean> hashMap = new HashMap();

        hashMap.put("valid",loginService.checkUser("loginname",cLoginname));
        System.out.println(hashMap);
        return JSON.toJSONString(hashMap);
    }

}

package com.luo.controller;

import com.alibaba.fastjson.JSONObject;
import com.luo.model.base.ReturnModel;
import com.luo.service.InitHouseList;
import com.luo.service.InterfaceTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/TestController")
public class TestController {

    @RequestMapping("/getBiuldList")
    public Map getHouseList(){
        InitHouseList initHouseList = new InitHouseList();

        Map retMap = new HashMap();
        retMap.put("status",0);
        retMap.put("mag","");
        retMap.put("data",initHouseList.getBiuldList("",""));


       return retMap;
    }


    @RequestMapping(value = "/getUnit")
    public Map getUnit(String biuldId){
        System.out.println("getUnit");
        System.out.println(biuldId);
        InitHouseList initHouseList = new InitHouseList();

        Map retMap = new HashMap();
        retMap.put("status",0);
        retMap.put("mag","");
        retMap.put("data",initHouseList.getBiuldList(biuldId,""));

        return retMap;
    }


    @RequestMapping(value = "/getRoom")
    public Map getRoom(String biuldId,String unitId){
        System.out.println("getRoom");
        System.out.println(biuldId+"====="+unitId);
        InitHouseList initHouseList = new InitHouseList();

        Map retMap = new HashMap();
        retMap.put("status",0);
        retMap.put("mag","");
        retMap.put("data",initHouseList.getBiuldList(biuldId,unitId));

        return retMap;
    }

}

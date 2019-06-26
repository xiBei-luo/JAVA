package com.luo.controller;

import com.luo.model.AreaModel;
import com.luo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Luowenlv on 2018/9/29,9:32
 * 可整合mybatis进行数据库操作
 */
@Controller
public class TestController {
    @Autowired
    private AreaService areaService;

    //@ResponseBody
    @RequestMapping(value = "/loadPage", method = RequestMethod.GET)
    public String loadPage(Model model) {
        model.addAttribute("areaList", areaService.getAllArea());
        return "plate/login";
        //List areaList = new ArrayList();
        //areaList = areaService.getAllArea();
        //System.out.println(areaList);
        //return areaList;
    }

    @RequestMapping(value = "/addAreaPage", method = RequestMethod.GET)
    public String addAreaPage() {
        return "addAreaPage";
    }

    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    public String addArea(AreaModel areaModel, Model model) {
        areaService.addArea(areaModel);
        model.addAttribute("areaList", areaService.getAllArea());
        return "index";
    }

    @RequestMapping(value = "/delAreaById/{area_id}", method = RequestMethod.GET)
    public String delAreaById(@PathVariable String area_id, Model model) {
        System.out.println(area_id);
        areaService.delAreaById(Integer.parseInt(area_id));
        model.addAttribute("areaList", areaService.getAllArea());
        return "redirect:index";
    }

    @RequestMapping(value = "/updateAreaById/{area_id}", method = RequestMethod.GET)
    public String updateAreaById() {

        return "udpAreaPage";
    }

    @RequestMapping(value = "/doUpdateArea", method = RequestMethod.POST)
    public String doUpdateArea() {

        return null;
    }


}

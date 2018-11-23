package com.luo.filetest.controller;

import com.luo.filetest.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class TestController {

    private ITestService testService;
    List userList = new ArrayList();

    @Autowired
    public TestController(ITestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/import")
    public String addUser(@RequestParam("file") MultipartFile file, Model model) {
        String fileName = file.getOriginalFilename();
        try {
            userList = testService.getExcelInfo(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator it = userList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        model.addAttribute("userList", userList);
        return "info";
    }

    @RequestMapping("/loadPage")
    public String loadPage() {
        System.out.println("in");
        return "index";
    }

}



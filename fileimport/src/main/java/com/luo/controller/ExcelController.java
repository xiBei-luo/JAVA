package com.luo.controller;

import com.luo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
@Controller
public class ExcelController {
    @Autowired
    ExcelService excelService;

    List userList = new ArrayList();

    @RequestMapping("/import")
    public String addUser(@RequestParam("file") MultipartFile file, Model model) throws Exception {
        String fileName = file.getOriginalFilename();
        excelService.getExcelInfo(fileName, file);
        return "info";
    }

    @RequestMapping("/loadPage")
    public String loadPage() {
        System.out.println("in");
        return "index";
    }
}

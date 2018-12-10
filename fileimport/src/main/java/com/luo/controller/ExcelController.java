package com.luo.controller;

import com.luo.model.ReturnInfoUtil;
import com.luo.model.ReturnUtil;
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
 * 完整demo，可解析excel并上传至数据库
 * 全表插入或插入部分列需修改参数ExcelServiceImpl->resultCell,并修改mapper文件指定需要插入的列
 */
@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    private ReturnInfoUtil returnInfoUtil;

    List userList = new ArrayList();

    @RequestMapping("/import")
    public String fileImport(@RequestParam("file") MultipartFile file,Model model) throws Exception {
        if (!checkFileSize(file,1048575,"B")){
            returnInfoUtil = ReturnUtil.error("上传文件过大");
        }

        String fileName = file.getOriginalFilename();
        ReturnInfoUtil returnInfoUtil = excelService.getExcelInfo(fileName, file);
        model.addAttribute("retInfo",returnInfoUtil);
        return "info";
    }

    @RequestMapping("/loadPage")
    public String loadPage() {
        return "index";
    }

    /**
     * 判断文件大小
     *
     * @param :multipartFile:上传的文件
     * @param size: 限制大小
     * @param unit:限制单位（B,K,M,G)
     * @return boolean:是否大于
     */
    public boolean checkFileSize( MultipartFile multipartFile, int size, String unit) {
        long len = multipartFile.getSize();//上传文件的大小, 单位为字节.
        //准备接收换算后文件大小的容器
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        //如果上传文件大于限定的容量
        if (fileSize > size) {
            return false;
        }
        return true;
    }


}

package com.luo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
public interface ExcelService {
    void getExcelInfo(String fileName, MultipartFile file) throws Exception;
}

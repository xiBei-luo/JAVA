package com.luo.service;

import com.luo.model.ReturnInfoUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
public interface ExcelService {
    public ReturnInfoUtil getExcelInfo(String fileName, MultipartFile file) throws Exception;
}

package com.luo.filetest.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITestService {

    List batchImport(String fileName, MultipartFile file) throws Exception;

    List getExcelInfo(String fileName, MultipartFile file) throws Exception;

}


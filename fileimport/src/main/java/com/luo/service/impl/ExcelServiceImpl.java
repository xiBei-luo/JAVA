package com.luo.service.impl;

import com.luo.dao.ExcelDao;
import com.luo.model.BankModel;
import com.luo.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    ExcelDao excelDao;


    @Override
    public void getExcelInfo(String fileName, MultipartFile file) throws Exception {
        List<BankModel> bankList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        BankModel bank;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            bank = new BankModel();


            String docNumber = row.getCell(0).getStringCellValue();
            String account = row.getCell(1).getStringCellValue();
            String time = row.getCell(2).getStringCellValue();
            String flag = row.getCell(3).getStringCellValue();
            String unit = row.getCell(4).getStringCellValue();
            String remark = row.getCell(5).getStringCellValue();
            String info = row.getCell(6).getStringCellValue();
            String moneyOut = row.getCell(7).getStringCellValue();
            String moneyIn = row.getCell(8).getStringCellValue();
            String Timestamp = row.getCell(9).getStringCellValue();

            System.out.println(docNumber);

            bank.setDocNumber(docNumber);
            bank.setAccount(account);
            bank.setFirstTime(time);
            bank.setFlag(flag);
            bank.setUnit(unit);
            bank.setRemark(remark);
            bank.setInfo(info);
            bank.setMoneyOut(moneyOut);
            bank.setMoneyIn(moneyIn);
            bank.setTimeEnd(Timestamp);

            bankList.add(bank);
            System.out.println(bankList);
        }
        /*ObjectMapper mapper = new ObjectMapper();
        String jsonList=mapper.writeValueAsString(bankList);*/
        //System.out.println(jsonList);
        excelDao.addUser(bankList);
        System.out.println(bankList);
    }
}

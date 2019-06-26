package com.luo.otherMethodDemo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.druid.util.StringUtils;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Luowenlv on 2018/12/11,15:57
 */
public class UploadFileServlet  extends HttpServlet {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/plain;charset=UTF-8");
        /*System.out.println(ServletFileUpload.isMultipartContent(request));*/
        JSONObject resultJson = new JSONObject();
        resultJson.put("ret", "0");
        resultJson.put("msg", "");


        Map impfileMap = getFilePath(request);//获取解析后的参数列表
        String userid = impfileMap.get("userid").toString();//操作人
        String headerStr = impfileMap.get("header").toString();//数组形式，需要转换
        String tableName = impfileMap.get("tableName").toString();//表名
        String tableFieldStr = impfileMap.get("tableField").toString();//数组形式，需要转换
        String[] tHeader = headerStr.split(",");//字符串转为字符串数组
        String[] tableField = tableFieldStr.split(",");//字符串转为字符串数组


        try {
            if(StringUtils.isEmpty(impfileMap.get("filePath").toString())) {
                throw new Exception("上传文件不能为空！");
            }

            // 同时支持Excel 2003、2007
            File excelFile = new File(impfileMap.get("filePath").toString());// 创建文件对象

            //文件是否存在
            if(!excelFile.exists()){
                throw new Exception("上传文件不存在！");
            }

            if(!(excelFile.isFile() && (excelFile.getName().endsWith(EXCEL_XLS) || excelFile.getName().endsWith(EXCEL_XLSX)))){
                throw new Exception("上传文件不是excel文件！");
            }

            FileInputStream in = new FileInputStream(excelFile); // 文件流

            Workbook workbook = null;
            if(excelFile.getName().endsWith(EXCEL_XLS)){  //Excel 2003
                workbook = new HSSFWorkbook(in);
            }else if(excelFile.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010
                workbook = new XSSFWorkbook(in);
            }

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet

            if(null == tHeader || tHeader.length <= 0) {
                throw new Exception("header不能为空！");
            }
            if(StringUtils.isEmpty(tableName)) {
                throw new Exception("tableName不能为空！");
            }
            if(null == tableField || tableField.length <= 0) {
                throw new Exception("tableField不能为空！");
            }
            if(StringUtils.isEmpty(userid)) {
                throw new Exception("userid不能为空！");
            }
            if(tHeader.length != tableField.length) {
                throw new Exception("header与tableField个数不一致！");
            }

            insertToTable(sheet, tHeader, tableName, tableField, userid);

            response.getWriter().write(resultJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.put("ret", "1");
            resultJson.put("msg", e.getMessage());
            response.getWriter().write(resultJson.toString());
        }
    }

    private void insertToTable(Sheet sheet, String[] tHeader, String tableName, String[] tableField, String userid)
            throws Exception{
        //System.out.println("insert--"+tHeader.toString()+"---"+tableName+"---"+tableField.toString()+"---"+userid);
        try {
            //获取总行数
            //System.out.println(sheet.getLastRowNum());

            if(sheet.getLastRowNum() <= 0) {
                throw new Exception("sheet不能为空！");
            }

            JSONArray indexArray = new JSONArray();//记录需要导入字段在excel的位置。
            //验证excel表头是否包含了指定的插入字段（tHeader）
            Row hearderRow = sheet.getRow(0);
            for(int i = 0;i < tHeader.length; i++) {
                boolean flag = false;
                String headerFiled = tHeader[i];
                for(int j = 0;j < hearderRow.getPhysicalNumberOfCells(); j++) {
                    String cellFiled =  getValue(hearderRow.getCell(j)).toString().trim() ;
                    if(headerFiled.equals(cellFiled) ) {
                        flag = true;
                        indexArray.add(i, j);
                        break;
                    }
                }

                if(!flag) {
                    throw new Exception("excel中不存在【" + tHeader[i] + "】字段！");
                }
            }


            ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
            JdbcTemplate jdbcTemplate = (JdbcTemplate) ct.getBean("jdbcTemplate");

            //先先删除该操作人对该导入中间表的操作数据
            jdbcTemplate.update("DELETE FROM " + tableName + " WHERE N_USERID = '" + userid + "'");

            //循环excel记录，并插入表中(都当字符串插入中间表),去除表头开始
            ArrayList sqlList = new ArrayList();
            StringBuffer sql_filed = new StringBuffer();
            StringBuffer sql_val = new StringBuffer();
            for(int i = 1; i<= sheet.getLastRowNum() ; i++) {
                Row row = sheet.getRow(i);

                sql_filed.setLength(0);
                sql_filed.append("INSERT INTO ").append(tableName).append("(");
                sql_val.setLength(0);
                sql_val.append(" VALUES( ");
                for(int j = 0;j < indexArray.size() ; j++) {
                    String field = tableField[j];//表的字段名
                    String cellFiled =  getValue(row.getCell(indexArray.getInt(j))).toString().trim() ;//对应excel单元格的内容

                    sql_filed.append(field).append(",");
                    sql_val.append("'"+cellFiled+"'").append(",");

                }
                //sql_filed.deleteCharAt(sql_filed.length()-1);//删除最后一个 逗号
                sql_filed.append(" N_USERID)");

                //sql_val.deleteCharAt(sql_val.length()-1);//删除最后一个 逗号
                sql_val.append("'"+userid+"'").append(")");

                String sql = sql_filed.append(sql_val.toString()).toString();
                //System.out.println("sql==="+sql);
                sqlList.add(sql);

                jdbcTemplate.update(sql);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("excel记录导入表中时失败!"+ e.getMessage());
        }

    }

    private static Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellType()) {
            case 4:
                obj = cell.getBooleanCellValue();
                break;
            case 5:
                obj = cell.getErrorCellValue();
                break;
            case 0:
                obj = cell.getNumericCellValue();
                break;
            case 1:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }//得到每一格的值

    /**
     * @param request
     * 根据请求解析请求中的参数(文件与非文件)返回Map集合,并将文件上传至服务器
     * @return
     */
    private static Map getFilePath(HttpServletRequest request) {
        String upload_directory = "upload";
        String slash_directory = "/";

        // 上传配置
        int memory_threshold   = 1024 * 1024 * 3;  // 3MB
        int max_file_size      = 1024 * 1024 * 40; // 40MB
        int max_request_size   = 1024 * 1024 * 50; // 50MB


        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(memory_threshold);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(max_file_size);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(max_request_size);

        upload.setHeaderEncoding("UTF-8");

        String uploadPath =  request.getContextPath()+slash_directory+upload_directory;
        String fileName="";
        String filePath="";
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        Map paramMap = new HashMap();

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        filePath = uploadPath + slash_directory + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        paramMap.put("fileName", fileName);
                        paramMap.put("filePath", filePath);
                    }else {
                        String value = item.getString("utf-8");
                        paramMap.put(item.getFieldName(), value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       /*Iterator<Map.Entry> entries = paramMap.entrySet().iterator();
	   while (entries.hasNext()) {
	     Map.Entry<Integer, Integer> entry = entries.next();
	     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	   }*/
        return paramMap;
    }
}

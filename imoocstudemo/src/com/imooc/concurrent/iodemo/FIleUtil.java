package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,10:31
 * 目录过滤，遍历
 */
public class FIleUtil {
    public static void listDirectory(File dir) throws IOException {
        if(!dir.exists()){
            throw new IllegalArgumentException("目录"+dir+"不存在");
        }

        if (!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }

        /*String[] fileNames = dir.list();//返回直接子目录的名称，对于子目录下的文件不适用
        for (String filename:fileNames){
            System.out.println(filename);
        }*/

        File[] files = dir.listFiles();//返回直接子目录的抽象
        /*for (File file:files){
            //System.out.println(file);

        }*/

        if (files!=null && files.length>0){
            for(File file:files){
                if(file.isDirectory()){
                    listDirectory(file);
                }else {
                    System.out.println(file);
                }
            }
        }


    }
}

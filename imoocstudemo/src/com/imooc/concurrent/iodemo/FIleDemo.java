package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,10:18
 */
public class FIleDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\iotest");
        if(!file.exists()){
            file.mkdir();
        }/*else{
            file.delete();
        }*/
        System.out.println(file);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
    }
}

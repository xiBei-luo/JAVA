package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,11:37
 */
public class IOUtilTest01 {
    public static void main(String[] args) throws IOException {
        //IOUtil.printHex("F:\\iotest\\SongController.java");
        IOUtil.printHexByByteArrays("F:\\iotest\\SongController.java");
    }
    public static void show(){
        System.out.println("111");
    }
}

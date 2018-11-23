package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,10:36
 */
public class FIleUtilTest01 {
    public static void main(String[] args) throws IOException {
        FIleUtil.listDirectory(new File("F:\\iotest"));


    }
}

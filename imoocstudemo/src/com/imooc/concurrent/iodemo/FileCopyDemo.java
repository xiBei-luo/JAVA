package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,15:10
 */
public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
        IOUtil.copyFile(new File("F:\\iotest\\srcFile.txt"),new File("F:\\iotest\\destFile.txt"));
    }
}

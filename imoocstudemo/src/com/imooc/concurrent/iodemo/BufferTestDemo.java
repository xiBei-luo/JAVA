package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,15:38
 */
public class BufferTestDemo {
    public static void main(String[] args) throws IOException {
        IOUtil.copyFileByBuffer(new File("f:\\iotest\\srcFile1.txt"), new File("f:\\iotest\\destFile1.txt"));
    }
}

package com.imooc.concurrent.iodemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,14:45
 */
public class FileOutDemo {
    public static void main(String[] args) throws IOException {


        FileOutputStream out = new FileOutputStream("F:\\iotest\\out.dat");
        out.write('A');//写入了A的低八位
        out.write('B');
        int a = 10;//整数需要写4次，每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.printHex("F:\\iotest\\out.dat");


    }
}

package com.imooc.concurrent.iodemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by Luowenlv on 2018/11/23,10:51
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("F:\\iotest");
        if (!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo,"raf.dat");
        if (!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        System.out.println(raf.getFilePointer());
        raf.write('A');//只写一个字节，即后八位
        System.out.println(raf.getFilePointer());
        raf.write('b');
        int i = 0x7fffffff;//write每次只写一个字节，要将i写进去要写四次
        raf.write(i>>>24);//依次写入高八位
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);
        System.out.println(raf.getFilePointer());
        //可以直接写一个int
        raf.writeInt(i);//底层源码与上方操作一致
        String s = "中";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.length());

        //读文件，必须将指针移到头部
        raf.seek(0);
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        raf.close();


    }
}

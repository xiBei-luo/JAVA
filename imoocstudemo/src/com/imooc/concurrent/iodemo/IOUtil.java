package com.imooc.concurrent.iodemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,11:32
 * 读取指定文件的内容按照16进制输出到控制台
 * 且每输出10个byte换一行
 */
public class IOUtil {
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i=1;
        while ((b=in.read())!=-1){
            if (b<=0xf){
                System.out.print("0");//单位数前面补0
            }
            System.out.print(Integer.toHexString(b)+"  ");
            if (i++%10==0){
                System.out.println();
            }
        }
        in.close();
    }
    public static void printHexByByteArrays(String filename) throws IOException{
        FileInputStream in = new FileInputStream(filename);
        byte[] buf = new byte[20*1024];
        int bytes = in.read(buf,0,buf.length);//返回读到的长度（有可能数组长度不够，也有可能数组长度过长，因此此方法只返回读到的长度，不管数组的长度是否足够）
        int j=0;
        for (int i=0;i<bytes;i++){
            if(buf[i]<=0xf){
                System.out.print("0"+buf[i]);
            }
            System.out.print(Integer.toHexString(buf[i])+"  ");
            if(i%10==0){
                System.out.println();
            }
        }
    }
}

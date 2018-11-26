package com.imooc.concurrent.iodemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/26,14:35
 */
public class FrFwDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("f:\\iotest\\fileReader.txt");;
        FileWriter fw = new FileWriter("f:\\iotest\\fileWriter.txt",true);//true追加而不是删除文件后新建
        char[] buffer = new char[1024];
        int c;
        while ((c=fr.read(buffer,0,buffer.length))!=-1){
            fw.write(buffer,0,c);
            fw.flush();
        }
        fr.close();
        fw.close();



    }
}

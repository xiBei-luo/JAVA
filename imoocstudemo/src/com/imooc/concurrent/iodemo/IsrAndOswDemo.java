package com.imooc.concurrent.iodemo;

import java.io.*;

/**
 * Created by Luowenlv on 2018/11/23,16:20
 */
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("F:\\iotest\\inputstreamread.txt");
        InputStreamReader isr = new InputStreamReader(in, "utf-8");//读取的文件本身的编码

        FileOutputStream out = new FileOutputStream("F:\\iotest\\outputstreamwriter.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");


        /*int c;
        while ((c=isr.read())!=-1){
            System.out.println((char)c);
        }*/
        char[] buffer = new char[8 * 1024];
        int c;
        while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
            String s = new String(buffer, 0, c);
            System.out.println(s + "---" + c);
            osw.write(buffer, 0, c);
            //osw.write(s,0,s.length());
            osw.flush();
        }
        isr.close();
        osw.close();

    }
}

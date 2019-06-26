package com.imooc.concurrent.iodemo;

import java.io.*;

/**
 * Created by Luowenlv on 2018/11/26,14:44
 */
public class BrBwDemo {
    public static void main(String[] args) throws IOException {
        //对一个文件进行读写操作
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("f:\\iotest\\bufferedreader.txt")
                )
        );

        /*BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("f:\\iotest\\bufferedwriter.txt")
                )
        );*/

        PrintWriter pw = new PrintWriter("f:\\iotest\\bufferedwriter.txt");


        String line;
        while ((line = br.readLine()) != null) {
            System.out.print(line);//一次读一行无法识别换行符
            /*bw.write(line);
            bw.newLine();
            bw.flush();*/
            pw.println(line);
            pw.flush();
        }

        br.close();
        pw.close();
        //bw.close();
    }
}

package com.imooc.concurrent.iodemo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,15:23
 */
public class DataIODemo2 {
    public static void main(String[] args) throws IOException {
        String file = "F:\\iotest/dos.dat";
        IOUtil.printHex(file);
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();
    }
}

package com.imooc.concurrent.iodemo;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Luowenlv on 2018/11/23,15:17
 */
public class DataIODemo {
    public static void main(String[] args) throws IOException {
        String file = "F:\\iotest/dos.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-1);
        dos.writeLong(10);
        dos.writeUTF("中国");//utf-8
        dos.writeChars("中国");//utf-16be

        dos.close();
        IOUtil.printHex(file);


    }
}

package com.imooc.concurrent.iodemo;

import java.io.UnsupportedEncodingException;

/**
 * Created by Luowenlv on 2018/11/23,9:23
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "慕课ABC";
        byte[] bytes1 = s.getBytes();
        for (byte b : bytes1) {
            System.out.println(b);
            //System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("=====");
        byte[] bytes2 = s.getBytes("gbk");
        for (byte b : bytes2) {
            System.out.println(b);
            //System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
    }
}

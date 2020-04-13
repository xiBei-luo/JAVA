package com.luo.service;

import com.luo.utils.HttpRequest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InterfaceDemo {
    public static void main(String[] args) {
        String tmpStr = md5("app_id=funi&area_id=e4439739-3e60-4c90-9a80-4da16bd0e92a","623169b7-f167-46cf-a52c-9e784ec24b1a");
        System.out.println(tmpStr);

        //System.out.println(HttpRequest.doGet("http://wyerp.funi.com/sys/interface/resdtList?app_id=funi&sign="+tmpStr));
        System.out.println(HttpRequest.doGet("http://wyerp.yijuweilai.com/sys/interface/resdtList?app_id=funi&sign="+tmpStr));

    }

    public static String md5(String str,String salt){
        String sum = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(salt.getBytes());
            md.update(str.getBytes());
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            sum = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sum;
    }

}

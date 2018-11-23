package com.imooc.concurrent.socket_url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Luowenlv on 2018/11/21,15:21
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL imooc = new URL("https://www.imooc.com");
        URL imoocNewURL =new URL(imooc,"/index.html?username=tom#test");
        System.out.println("协议："+imoocNewURL.getProtocol());
        System.out.println("主机："+imoocNewURL.getHost());
        System.out.println("端口："+imoocNewURL.getPort());//getPort方法在未指定端口号的时候返回-1
        System.out.println("文件路径："+imoocNewURL.getPath());
        System.out.println("文件名："+imoocNewURL.getFile());
        System.out.println("相对路径："+imoocNewURL.getRef());
        System.out.println("查询字符串："+imoocNewURL.getQuery());

    }
}

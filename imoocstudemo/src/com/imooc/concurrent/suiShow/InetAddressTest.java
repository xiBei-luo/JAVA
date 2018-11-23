package com.imooc.concurrent.suiShow;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Luowenlv on 2018/11/21,15:02
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();//获取本机
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());

        System.out.println("==========");
        InetAddress address1 = InetAddress.getByName("192.168.155.1");//根据IP获取
        System.out.println(address1.getHostName());
        System.out.println(address1.getHostAddress());
    }
}

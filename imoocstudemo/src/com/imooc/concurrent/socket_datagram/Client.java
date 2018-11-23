package com.imooc.concurrent.socket_datagram;

import java.io.IOException;
import java.net.*;

/**
 * Created by Luowenlv on 2018/11/21,16:57
 * 基于UDP的用户登陆——客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名：tom；密码：1234".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        //接受服务器端的响应信息
        byte[] data2=new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
        socket.receive(packet2);
        String reply = new String(data2,0,packet2.getLength());
        System.out.println("我是客户端，服务器端说："+reply);;
        socket.close();

    }
}

package com.imooc.concurrent.socket_datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Luowenlv on 2018/11/21,16:57
 * 基于UDP的用户登陆——服务器端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8800);
        byte[] data = new byte[1024];
        int count = 0;
        System.out.println("服务器端已经启动，等待客户端发送数据");

        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            ServerThread serverThread = new ServerThread(packet, socket, data);
            serverThread.start();
            count++;
            System.out.println("客户端的数量：" + count);
        }


    }
}

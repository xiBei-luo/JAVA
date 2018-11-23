package com.imooc.concurrent.socket_datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Luowenlv on 2018/11/21,17:17
 */
public class ServerThread extends Thread {
    DatagramSocket socket = null;
    String data = null;
    InetAddress address = null;
    int port = 0;


    public  ServerThread(DatagramPacket packet,DatagramSocket socket,byte[] data){
        this.socket = socket;
        this.data = new String(data,0,packet.getLength());
        this.port = packet.getPort();
        this.address = packet.getAddress();
    }


    public void run(){
        System.out.println("我是服务器，客户端说"+data);

        //服务器端相应客户端
        byte[] data2 = "欢迎你！".getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        try {
            socket.send(packet2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

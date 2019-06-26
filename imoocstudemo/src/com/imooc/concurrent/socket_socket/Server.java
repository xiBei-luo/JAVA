package com.imooc.concurrent.socket_socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Luowenlv on 2018/11/21,16:01
 * 基于TCP协议的socket通信，实现用户登录
 * <p>
 * 服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = null;
        int count = 0;
        System.out.println("服务器即将启动，等待客户端的连接");
        while (true) {
            socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
            count++;
            System.out.println("客户端的数量：" + count);
            InetAddress address = socket.getInetAddress();
            System.out.println("当前客户端的IP：" + address.getHostAddress());
        }
    }
}

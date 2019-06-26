package com.luo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Luowenlv on 2019/4/1,11:33
 */
public class MulServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;
            while (true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端的数量为--"+count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("客户端是--"+inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

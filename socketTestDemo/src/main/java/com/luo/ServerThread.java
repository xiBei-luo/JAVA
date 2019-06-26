package com.luo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Luowenlv on 2019/4/1,11:22
 */
public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("客户端传入的信息是--" + info);
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);

            printWriter.write("我是服务器，欢迎你客户端--");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (printWriter!=null)
                    printWriter.close();
                if (outputStream!=null)
                    outputStream.close();
                if (bufferedReader!=null)
                    bufferedReader.close();
                if (inputStream!=null)
                    inputStream.close();
                if (bufferedReader!=null)
                    bufferedReader.close();
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

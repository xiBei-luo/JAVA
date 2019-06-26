package com.luo;

import java.io.*;
import java.net.Socket;

/**
 * Created by Luowenlv on 2019/4/1,10:56
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：刘理;密码：789789");
            printWriter.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("我是客户端，服务器端说--" + info);
            }
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

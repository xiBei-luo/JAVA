package com.imooc.concurrent.socket_socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Luowenlv on 2018/11/21,16:01
 *
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名：tom;密码：456");
        pw.flush();
        socket.shutdownOutput();

        //接收服务器的相应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while ((info = br.readLine()) != null){
            System.out.println("我是客户端，服务器端说"+info);
        }

        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();

    }
}

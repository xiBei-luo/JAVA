package com.imooc.concurrent.socket_socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Luowenlv on 2018/11/21,16:26
 */
public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println("我是服务器，客户端说"+info);
            }
            socket.shutdownInput();

            //响应客户端
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎你");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pw != null)
                    pw.close();
                if(os != null)
                    os.close();
                if(isr != null)
                    isr.close();
                if(br != null)
                    br.close();
                if(is != null)
                    is.close();
                if(socket != null)
                    socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }//相应客户端请求的操作


}

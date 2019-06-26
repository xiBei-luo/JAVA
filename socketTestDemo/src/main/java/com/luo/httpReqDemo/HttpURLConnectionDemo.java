package com.luo.httpReqDemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Luowenlv on 2019/4/1,14:04
 * 利用HttpURLConnection向服务器发起个体或post请求（成功）
 */
public class HttpURLConnectionDemo {
    public static void main(String[] args) {
        //System.out.println(get());
        System.out.println(post());
    }
    public static String get(){
        String message = "";
        try {
            URL url = new URL("http://baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5*1000);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] data = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            int length = 0;
            while ((length = inputStream.read(data)) != -1){
                String s = new String(data,Charset.forName("utf-8"));
                stringBuffer.append(s);
            }
            message = stringBuffer.toString();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
    public static String post(){
        String message = "";
        try {
            URL url = new URL("http://cdgys.cdmcs.com/cdgysappsso/login");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestProperty("Conten-type", "application/x-javascript->json");
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("email=");
            stringBuffer.append("123456781.com&");
            stringBuffer.append("password=");
            stringBuffer.append("1234&");
            stringBuffer.append("verify_code=");
            stringBuffer.append("4fj8");
            String param = stringBuffer.toString();
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] data = new byte[1024];
            StringBuffer stringBuffer1 = new StringBuffer();
            int length = 0;
            while ((length = inputStream.read(data)) != -1){
                String string = new String(data,Charset.forName("utf-8"));
                stringBuffer1.append(string);
            }
            message = stringBuffer1.toString();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}

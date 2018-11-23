package com.imooc.concurrent.socket_url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Luowenlv on 2018/11/21,15:34
 */
public class URLTest02 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        while (data != null){
            System.out.println(data);
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();


    }
}

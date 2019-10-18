package com.greenplatform.configer;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //System.out.println("创建session");
        online ++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //System.out.println("销毁session");
        online --;
    }

}

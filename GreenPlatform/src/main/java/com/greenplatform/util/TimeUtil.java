package com.greenplatform.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    //获取当前系统时间timestamp
    public static Timestamp getTimestamp(Date date){
        if (null == date){
            date = new Date();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
    //获取系统当前时间   2019-05-22 16:35:01
    public static String getLocalDate(Date date){
        if (null == date){
            date = new Date();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String localDate = df.format(date);
        return localDate;
    }
}

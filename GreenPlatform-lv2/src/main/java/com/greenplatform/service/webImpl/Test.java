package com.greenplatform.service.webImpl;

import com.greenplatform.util.TimeUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String dBrwDay = getPrevTimeOfCur(TimeUtil.getLocalDate(new Date()),-1);
        System.out.println(dBrwDay);
        Timestamp ts = Timestamp.valueOf(dBrwDay);
        System.out.println(ts);
    }
    private static String getPrevDayOfCur(String time,int day){
        String sub = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date timeNow = df.parse(time);
            Calendar begin=Calendar.getInstance();
            begin.setTime(timeNow);
            begin.add(Calendar.DAY_OF_MONTH,day);
            sub = df.format(begin.getTime());
            //System.out.println(sub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sub;
    }

    private static String getPrevTimeOfCur(String time,int day){
        String sub = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date timeNow = df.parse(time);
            Calendar begin=Calendar.getInstance();
            begin.setTime(timeNow);
            begin.add(Calendar.DAY_OF_MONTH,day);
            sub = df.format(begin.getTime());
            //System.out.println(sub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sub;
    }
}

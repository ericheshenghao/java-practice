package com.company.chapter19.日期处理;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {
    public static void main(String[] args) {
        // 1970-01-01 00:00:00 001
        Date time = new Date(1); // 参数是一个毫秒数

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // 北京是东八区 差八个小时
        System.out.println(sdf.format(time));
        // 获取昨天的此时的时间
        Date time2 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        String strTime2 = sdf.format(time2);
        System.out.println(strTime2);
    }
}

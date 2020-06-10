package com.company.chapter19.日期处理;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
怎么获取系统当前时间

 */

public class Test01 {
    public static void main(String[] args) throws ParseException {
        //获取系统当前时间
        // java.util.data
        // 直接调用的是无参数构造方法
        Date now = new Date();
        // tostring方法已经被重写了
        System.out.println(now); //Wed Apr 15 15:43:16 CST 2020
        // 将日期转换为想要的格式
        // java.text包下专门负责日期格式化；
        // yyyy-mm-dd-hh-mm-ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(now));

        // 假设现在有一个日期字符串string，怎么转为data类型
        String time = "2008-08-08 08:08:08";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf2.parse(time));


    }
}

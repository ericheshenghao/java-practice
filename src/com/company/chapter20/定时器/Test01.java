package com.company.chapter20.定时器;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test01 {
    public static void main(String[] args) throws ParseException {
        //创建定时器对象
        Timer timer = new Timer();
//        Timer timer = new Timer(true);守护进程模式
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // （定时任务，第一次执行时间，没隔多久执行一次）
        Date firstTime = sdf.parse("2020-04-20 09:30:00");
        timer.schedule(new LogTimerTask(), firstTime, 10 * 1000);
    }
}

// 编写一个定时任务类
//假设是一个记录日志的定时器
class LogTimerTask extends TimerTask {

    @Override
    public void run() {
        // 需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ": 备份成功");
    }
}
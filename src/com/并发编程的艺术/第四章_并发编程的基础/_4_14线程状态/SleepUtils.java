package com.并发编程的艺术.第四章_并发编程的基础._4_14线程状态;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch(Exception e){
            e.printStackTrace();
        };
    }
}

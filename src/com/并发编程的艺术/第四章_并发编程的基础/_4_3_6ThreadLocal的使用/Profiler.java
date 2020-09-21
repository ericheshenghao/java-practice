package com.并发编程的艺术.第四章_并发编程的基础._4_3_6ThreadLocal的使用;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

public class Profiler {
    // 第一次get()方法调用时会进行初始化(如果 set 方法没有调用)，每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };
    
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
        
    }
    
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: "+Profiler.end()+" miles");
    }
    
}

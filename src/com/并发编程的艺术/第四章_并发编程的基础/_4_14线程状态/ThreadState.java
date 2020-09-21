package com.并发编程的艺术.第四章_并发编程的基础._4_14线程状态;

import java.util.concurrent.TimeUnit;

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();

    }

    // 该线程不断的睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true){
                SleepUtils.second(100);
            }
        }
    }

    // 该线程不断的等待
    static class  Waiting implements Runnable {
        @Override
        public void run() {
           while (true){
               synchronized (Waiting.class){
                   try {
                   Waiting.class.wait();
                   }catch(Exception e){
                       e.printStackTrace();
                   };
               }
           }
        }
    }

    // 该线程在bloked.class枷锁后，不会释放锁
    static class  Blocked implements Runnable {
        @Override
        public void run() {
           synchronized (Blocked.class){
               while (true){
                   SleepUtils.second(100);
               }
           }
        }
    }
}

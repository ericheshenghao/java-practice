package com.并发编程的艺术.第四章_并发编程的基础._4_3_2等待通知;

import com.并发编程的艺术.第四章_并发编程的基础._4_14线程状态.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag =true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitTread = new Thread(new Wait(),"WaitThread");
        waitTread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread = new Thread(new Notify(), "NotifyThread");
        thread.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            // 加锁，拥有lock的monitor
            synchronized (lock){
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag){
                    try {
                    System.out.println(Thread.currentThread()+"flag is true. wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                }

                System.out.println(Thread.currentThread()+"flag is false. running @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }

        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {
            // 加锁，拥有lock的monitor
          synchronized (lock){
              // 获取lock的锁，然后进行通知，通知时不会释放lock的锁
              System.out.println(Thread.currentThread()+" hold lock. notify @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
              lock.notifyAll();
              flag=false;
              SleepUtils.second(5);
          }

          synchronized (lock){
              System.out.println(Thread.currentThread()+" hold lock again. sleep @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
              SleepUtils.second(5);
          }
        }
    }
}

package com.company.chapter20.多线程;

import java.util.concurrent.TimeUnit;

/*
sleep睡眠太久了，如果希望醒来，你应该怎么办，也就是说怎么叫醒
不是u终止线程
 */
public class Test08 {
    public static void main(String[] args) {
        Thread t = new Thread(new Myrunnable2());
        t.setName("t");
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断睡眠 靠异常处理机制
        t.interrupt();

    }
}


// 继承的父类没有抛出异常，子类不能比父类抛出更多的异常
class Myrunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "begin");
        try {
            Thread.sleep(1000 * 60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }
}
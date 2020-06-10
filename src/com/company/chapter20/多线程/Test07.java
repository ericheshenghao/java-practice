package com.company.chapter20.多线程;

public class Test07 {
    public static void main(String[] args) {
        Mythread3 t = new Mythread3();
        t.setName("t");
        t.start();


        try {
            t.sleep(1000 * 5);  // 在执行的时候会转换成： Thread.sleep(5)
            // main线程进入睡眠
            // 让当前进程进入睡眠

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}

class Mythread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
        }
    }
}
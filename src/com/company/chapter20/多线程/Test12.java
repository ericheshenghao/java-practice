package com.company.chapter20.多线程;

/*
让位
让给其他线程
 */
public class Test12 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable6());
        t.setName("t");
        t.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyRunnable6 implements Runnable {


    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 100 让位一个
            if (i % 100 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
package com.company.chapter20.多线程;

/*
第二种方式

 */
public class Test03 {
    public static void main(String[] args) {
        Myrunable r = new Myrunable();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程：" + i);
        }
    }
}


// 这并不是一个线程，是一个可运行的类
class Myrunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程：" + i);
        }
    }
}
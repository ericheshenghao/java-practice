package com.company.chapter20.多线程;

/*
 采用匿名内部类
 */
public class Test04 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        });
        t.start();
    }
}

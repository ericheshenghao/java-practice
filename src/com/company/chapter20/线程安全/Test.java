package com.company.chapter20.线程安全;

/*
不使用线程同步机制，出现线程安全问题
 */
public class Test {
    public static void main(String[] args) {
        Account act = new Account("at-001", 10000);
        // 创建两个线程
        Thread t1 = new AccoutThread(act);
        Thread t2 = new AccoutThread(act);
        // 设置name
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

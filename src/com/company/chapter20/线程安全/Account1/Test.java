package com.company.chapter20.线程安全.Account1;


/*
不使用线程同步机制，出现线程安全问题
 */
public class Test {
    public static void main(String[] args) {
        // 只new了一个account
        Account1 act = new Account1("at-001", 10000);
        // 创建两个线程
        Thread t1 = new AccoutThread(act);
        Thread t2 = new AccoutThread(act);
        // 开启另一个坑位，如果两人要上厕所，需排队
        Account1 act2 = new Account1("act-002", 5000);
        Thread t3 = new AccoutThread(act2);

        // 多个和坑位之间互不影响

        // 设置name
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

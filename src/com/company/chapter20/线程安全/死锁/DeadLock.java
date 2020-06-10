package com.company.chapter20.线程安全.死锁;

import javafx.beans.binding.ObjectExpression;

/*
 死锁代码要会写
 一般面试要求你会写
 只有会写的，才会在开发中注意这个事
 因为死锁很难调式
 */
public class DeadLock {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Mythread1(o1, o2);
        Thread t2 = new Mythread2(o1, o2);

        t1.start();
        t2.start();

    }
}


class Mythread1 extends Thread {
    Object o1;
    Object o2;

    public Mythread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;

    }

    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }
        }
    }

}

class Mythread2 extends Thread {
    Object o1;
    Object o2;

    public Mythread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;

    }

    public void run() {
        synchronized (o2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {

            }
        }
    }
}
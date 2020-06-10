package com.多线程编程核心技术.第二章_对象及变量的并发访问.内置类与同步试验1;


public class Run {
    public static void main(String[] args) {
       final OutClass.Inner inner = new OutClass.Inner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        },"A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        },"B");
        t1.start();
        t2.start();
    }
}

package com.company.chapter20.多线程;

/*
获取线程对象
获取线程对象的名字 t.getName()
修改线程对象的名字  t.setName()
 */
public class Test05 {
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        MyThread1 t = new MyThread1();
        t.setName("t3");
        System.out.println(t.getName());
        //启动线程
        MyThread1 t2 = new MyThread1();
        t.setName("t2");
        t2.start();

        t.start();
    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(this.getName() + ">>>>" + i);
        }
    }
}

package com.company.chapter20.线程安全.Example3;

/*
不要等待，是两把锁
 */
public class Text01 {
    public static void main(String[] args) {
        MyClass mc1 = new MyClass();

        MyClass mc2 = new MyClass();

        Thread t1 = new MyThread(mc1);
        Thread t2 = new MyThread(mc2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

    }
}

class MyThread extends Thread {
    private MyClass mc;

    public MyThread(MyClass mc) {
        this.mc = mc;

    }

    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            mc.doSome();
        }

        if (Thread.currentThread().getName().equals("t2")) {
            mc.doother();
        }

    }
}

class MyClass {
    public synchronized void doSome() {
        System.out.println("doSome begin");

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("doSome over");

    }

    public synchronized void doother() {
        System.out.println("doother begin ");
        System.out.println("doother over");
    }
}

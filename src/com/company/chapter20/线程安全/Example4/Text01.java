package com.company.chapter20.线程安全.Example4;

/*
这里需要等待
类锁只有一把
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
    // synchronized出现在静态方式上用的是类锁
    public synchronized static void doSome() {
        System.out.println("doSome begin");

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("doSome over");

    }

    public synchronized static void doother() {
        System.out.println("doother begin ");
        System.out.println("doother over");
    }
}

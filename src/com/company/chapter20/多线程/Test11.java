package com.company.chapter20.多线程;

/*
关于线程的优先级
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println("最高优先级" + Thread.MAX_PRIORITY);
        System.out.println("最高优先级" + Thread.MIN_PRIORITY);
        System.out.println("最高优先级" + Thread.NORM_PRIORITY);

        // 获取当前线程的优先集

        int currrent = Thread.currentThread().getPriority();
        System.out.println(currrent);

        Thread t = new Thread(new MyRunnable());
        t.setPriority(10);
        t.setName("t");
        t.start();

        // 优先级较高的，只是抢到的时间片更多
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程的优先级：" + Thread.currentThread().getPriority());
    }
}
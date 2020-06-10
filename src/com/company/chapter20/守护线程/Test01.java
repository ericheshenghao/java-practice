package com.company.chapter20.守护线程;

/*
守护线程
 */
public class Test01 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        // 启动线程之前，将线程设置为守护线程
        t.setDaemon(true);
        t.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BakDataThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {

            System.out.println(Thread.currentThread().getName() + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


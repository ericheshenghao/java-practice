package com.company.chapter20.多线程;

/*
合理的终止一个线程
 */
public class Test10 {
    public static void main(String[] args) {
        Myrunnable4 myrunnable = new Myrunnable4();
        Thread t = new Thread(myrunnable);
        t.setName("t");
        t.start();
        // 模拟5s中

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 终止线程
        //修改属性即可
        myrunnable.run = false;
    }
}

class Myrunnable4 implements Runnable {
    public boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run) {
                System.out.println(Thread.currentThread().getName() + ">>>>" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // 终止线程
                return;
            }
        }
    }
}

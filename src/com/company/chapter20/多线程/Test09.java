package com.company.chapter20.多线程;

/*
强制关闭线程容易丢失数据
 */
public class Test09 {
    public static void main(String[] args) {
        Thread t = new Thread(new Myrunnable3());
        t.setName("t");
        t.start();
        // 模拟5s中

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.stop(); //不建议使用

    }
}

class Myrunnable3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>>" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

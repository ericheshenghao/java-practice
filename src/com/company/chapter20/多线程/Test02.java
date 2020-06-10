package com.company.chapter20.多线程;

/*
继承 Thread
怎么创建线程对象，启动
 */
public class Test02 {
    public static void main(String[] args) {
        // 与逆行
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // 编写程序，这段程序运行再分支中
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
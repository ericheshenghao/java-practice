package com.company.chapter20.waitnotify;

import java.util.ArrayList;
import java.util.List;

/*
生产者和消费者模式
2、
生产线程负责生产，消费线程负责消费

3、不是线程对象的方法，是普通对象的方法
4、建在线程同步的基础之上，同时操作一个仓库，有线程安全问题

5、作用：o。wait让线程t进入等待
6、notify 让线程唤醒

7、 模拟一个需求
    仓库我们采用list集合
    list集合中假设只能存储1个元素
    保证只能储存一个‘
    生产一个消费一个
 */
public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        // 创建两隔线程对象
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");
        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {
    private List list;
    //仓库


    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直生产
        while (true) {
            // 给仓库对象list加锁
            synchronized (list) {
                if (list.size() > 0) {
                    //等待
                    try {
                        list.wait();  // 释放掉之前占有的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 空仓库生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>" + obj);
                // 唤醒消费折
                list.notify();
            }

        }

    }
}

//消费线程
class Consumer implements Runnable {

    private List list;
    //仓库

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直消费
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait(); // 仓库空了释放掉锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>" + obj);
                //唤醒生产者 锁不会释放
                list.notify();

            }
        }
    }
}

package com.日期归档.l2021年02月02日.按序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : heshenghao
 * @date : 19:56 2021/2/2
 */


/**
 * @author : heshenghao
 * @date : 19:56 2021/2/2
 */
class Foo {
    ReentrantLock lock =  new ReentrantLock();

    Condition waitAPrint = lock.newCondition();
    Condition waitBPrint = lock.newCondition();
      volatile boolean isAPrint = false;
      volatile boolean isBPrint = false;
    public Foo() {

    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t3.start();
        t2.start();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            printFirst.run();
            isAPrint = true;
            waitAPrint.signal();
        }finally {
            lock.unlock();
        }

    }

    public  void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        // printSecond.run() outputs "second". Do not change or remove this line.

        try{
            if (!isAPrint){
                waitAPrint.await();
            }
            printSecond.run();
            isBPrint =true;
            waitBPrint.signal();
        }finally{
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        // printThird.run() outputs "third". Do not change or remove this line.
        try{

            if (!isBPrint){
                waitBPrint.await();
            }
            printThird.run();
        }finally{
            lock.unlock();
        }

    }
}
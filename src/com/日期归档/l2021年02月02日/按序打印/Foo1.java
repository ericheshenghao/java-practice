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


/**
 * @author : heshenghao
 * @date : 19:56 2021/2/2
 */
class Foo1 {

    public Foo1() {

    }

    private Object object = new Object();
    volatile int  status = 1;

    public   void first(Runnable printFirst) throws InterruptedException {


        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(object){
        printFirst.run();
        status = 2;
        object.notifyAll();
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(object){
            while(status != 2){
            object.wait();
        }
        printSecond.run();
        status = 3;
        object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(object) {
            while (status != 3) {
                object.wait();
            }

            printThird.run();
        }

    }
}
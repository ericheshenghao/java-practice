package com.日期归档.l2021年02月02日.按序打印;


/**
 * @author : heshenghao
 * @date : 19:56 2021/2/2
 */
class Foo2 {

    public Foo2() {

    }


    public   void first(Runnable printFirst) throws InterruptedException {


        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();

    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        printSecond.run();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

            printThird.run();


    }
}
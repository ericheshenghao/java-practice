package com.日期归档.l2021年02月04日;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author : heshenghao
 * @date : 11:04 2021/2/4
 */
class FizzBuzz {
    private int n;
    volatile int start =1;
    Object o = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"fizz");

        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"buzz");

        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"fizzbuzz");

        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number((s) -> {
                    System.out.println(s);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"number");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }


        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {

            synchronized(o){
                for( ; start <= n;  ){
                    if(start%3!=0 || start%5==0){

                        o.wait();

                    }else{
                        printFizz.run();
                        ++start;
                        o.notifyAll();
                    }

                }

            }

        }


        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {

            synchronized(o){
                for( ; start <= n;  ){
                    if(start%5!=0 || start%3==0){

                        o.wait();
                    }else{
                        printBuzz.run();
                        ++start;
                        o.notifyAll();
                    }



                }


            }

        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

            synchronized(o){
                for( ; start <= n;  ){
                    if(start%5!=0 || start%3!=0){

                        o.wait();
                    }else{
                        printFizzBuzz.run();
                        ++start;
                        o.notifyAll();
                    }



                }
            }
        }


        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {

            synchronized(o){
                for( ; start <= n;  ){
                    if(start%5 ==0 || start%3==0){
                        o.wait();
                    }else {
                        printNumber.accept(start);
                        ++start;
                        o.notifyAll();
                    }

                }
            }
        }

    }
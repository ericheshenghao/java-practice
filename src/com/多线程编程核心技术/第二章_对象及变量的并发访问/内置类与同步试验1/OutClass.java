package com.多线程编程核心技术.第二章_对象及变量的并发访问.内置类与同步试验1;

public class OutClass {
    static class Inner{
        public void method1(){
            synchronized ("其他的锁"){
                for (int i = 1; i <=10; i++) {
                    System.out.println(Thread.currentThread().getName()+"i ="+i);
                    try {
                    Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                }
            }
        }
        public synchronized void method2(){

                for (int i = 1; i <=20; i++) {
                    System.out.println(Thread.currentThread().getName()+"i ="+i);
                    try {
                        Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                }
        }
    }
}

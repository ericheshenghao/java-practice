package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.单例模式.线程单例实现;



class  main {
     public static void main(String[] args) throws InterruptedException {
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         System.out.println(ThreadLocalSingleton.getInstance());
         Thread t1 = new Thread(() -> {
             ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
             System.out.println(instance);
         });
         Thread t2 = new Thread(()->{
             ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
             System.out.println(instance);
         });
         t1.start();
         t2.start();
//         Thread.sleep(10000);
         System.out.println("end");

     }
}


public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private  ThreadLocalSingleton(){}

    public static  ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

}

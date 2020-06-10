package com.设计模式及实践.第二章__创建型模式.单例模式.无锁的线程安全单例模式;


class main{
    public static void main(String[] args) {

       MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);

        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");


        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LockFreeSingleton.getInstance().hashCode());
    }
}


public class LockFreeSingleton {
    private static final LockFreeSingleton instance =new LockFreeSingleton();
    private  LockFreeSingleton(){
        System.out.println("LockFreeSingleton is Instantiated");
    }

    public  static synchronized LockFreeSingleton getInstance(){
        return instance;
    }

    public void doSomeThing(){
        System.out.println("Something is Done");
    }
}

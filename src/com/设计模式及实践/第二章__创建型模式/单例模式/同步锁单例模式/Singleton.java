package com.设计模式及实践.第二章__创建型模式.单例模式.同步锁单例模式;



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
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Singleton.getInstance().hashCode());
    }
}


public class Singleton {
    private static Singleton instance;
    private  Singleton(){
        System.out.println("Singleton is Instantiated");
    }

    // 下面两种锁比较重，开销比较大
//    public static synchronized Singleton getInstance(){
//        if (instance==null)  instance= new Singleton();
//        return instance;
//    }

    public static  Singleton getInstance(){
        synchronized(Singleton.class){
            if (instance==null)  instance= new Singleton();
        }
        return instance;
    }



    public void doSomeThing(){
        System.out.println("Something is Done");
    }

}

package com.设计模式及实践.第二章__创建型模式.单例模式.拥有双重校验锁机制的同步锁单例模式;



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
        System.out.println(SIngletonSync2.getInstance().hashCode());
    }
}


public class SIngletonSync2 {
    private static SIngletonSync2 instance;
    private  SIngletonSync2(){
        System.out.println("Singleton is Instantiated");
    }




    public static SIngletonSync2 getInstance(){
        // 这样子加锁的话，如果该实例已经实例化过，那么获取该实例的行为将不再是同步行为，任何
        // 线程都可以用非同步的方式获取当前的实例
        if(instance==null){
            synchronized(SIngletonSync2.class){
                if (instance==null)  instance= new SIngletonSync2();
            }
        }

        return instance;
    }



    public void doSomeThing(){
        System.out.println("Something is Done");
    }

}

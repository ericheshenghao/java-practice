package com.设计模式及实践.第二章__创建型模式.单例模式;


class main{
    public static void main(String[] args) {

        Singleton.getInstance().doSomeThing();
    }
}


public class Singleton {
    private static Singleton instance;
    private  Singleton(){
        System.out.println("Singleton is Instantiated");
    }
    public static Singleton getInstance(){
        if (instance==null)  instance= new Singleton();
            return instance;
    }
    
    
    public void doSomeThing(){
        System.out.println("Something is Done");
    }
    
}

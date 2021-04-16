package com.测试.单例.懒汉式;

/**
 * @author : heshenghao
 * @date : 21:26 2021/2/8
 */
public class Singleton {

    private static volatile Singleton singleton = null;
    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton!=null){
            return singleton;
        }
        synchronized (Singleton.class){
            if(singleton != null){
                return singleton;
            }
            singleton = new Singleton();
            return  singleton;
        }
    }
}

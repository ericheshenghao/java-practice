package com.测试.单例.饿汉式;

/**
 * @author : heshenghao
 * @date : 21:28 2021/2/8
 */
public class Singleton {

    Singleton singleton = new Singleton();

    public Singleton getSingleton() {
        return singleton;
    }
}

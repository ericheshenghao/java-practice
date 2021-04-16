package com.测试.单例.懒汉式;

/**
 * @author : heshenghao
 * @date : 21:26 2021/2/8
 */
public final class Singleton1 {
    private Singleton1() { }
    // 问题1：属于懒汉式还是饿汉式
    private static class LazyHolder {
        static final Singleton1 INSTANCE = new Singleton1();
    }
    // 问题2：在创建时是否有并发问题
    public static Singleton1 getInstance() {
        return LazyHolder.INSTANCE;
    }
}


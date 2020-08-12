package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.单例模式;

public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}
    public  static  HungrySingleton  getInstance(){
       return  hungrySingleton;
    }
}


 class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public  static  final  LazyInnerClassSingleton  getInstance(){
        return  LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
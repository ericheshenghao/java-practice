package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.代理模式;

public class main {
    public static void main(String[] args) {
        // 帮儿子找对象
        Father father = new Father(new Son());
        father.findLove();
    }
}

/**
 * 人有很多行为，谈恋爱，住房子
 */
interface Person{
    public  void findLove();
}

class Son implements Person{

    @Override
    public void findLove() {
        System.out.println("儿子要求，肤白貌美大长腿");
    }

}

class Father {
    private Son son;
    public Father(Son son){
        this.son = son;
    }
    public void findLove(){
        System.out.println("父亲物色对象");
        this.son.findLove();
        System.out.println("双方同意交往，确立关系");
    }
}
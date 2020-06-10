package com.company;

/**
 * 抽象类无法实例化，但是抽象类有构造方法供子类使用
 * 抽象方法表示没有实现的方法，没有方法体的方法。
 * public abstract void do();
 * 抽象类中不一定需要抽象方法
 * 抽象方法必须出现在抽象类中
 * java语言中凡是没有方法体的方法都是抽象方法 错误
 * Object类中有很多方法没有方法体
 */
public class Main {
    public static void main(String[] args) {

    }
}


abstract class Account {
    // 非抽象方法
    public void dosomething() {
    }

    // 抽象方法
    public abstract void withdraw();
}
// 子类可以实例化
//class CreditAccount extends Account {
//    public CreditAccount(){
//        super();
//    }
//}
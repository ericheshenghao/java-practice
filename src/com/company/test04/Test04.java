package com.company.test04;

public class Test04 {
    public static void main(String[] args) {
        // 表面看animal没有起作用
        flyable f = new Cat();
        f.fly();
        flyable fish = new Fish();
        fish.fly();
    }
}

class Animal {
}

// 可飞
// 可插拔得就是接口
// 接口通常提取的是行为动作
interface flyable {
    void fly();
}

// 动物类子类
// 添加一个可以飞得接口
class Cat extends Animal implements flyable {

    @Override
    public void fly() {
        System.out.println("猫的飞翔方法");
    }
}

// 蛇类,不想飞,可以不实现接口
// 没有接口就不能飞
class Snake extends Animal {

}

// 鱼,没有继承动物类的时候
class Fish extends Object implements flyable {

    @Override
    public void fly() {
        System.out.println("鱼的飞翔方法");
    }
}
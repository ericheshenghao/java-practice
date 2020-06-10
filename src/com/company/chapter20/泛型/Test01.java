package com.company.chapter20.泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
泛型

 */
public class Test01 {
    public static void main(String[] args) {
        // 不使用泛型存在的缺点
        // 指定使用泛型,表示集合中只允许存储animal类型的数据
        // 用泛型指定集合中存储的数据类型
        // 集合中的数据类型更加统一了'
        // 泛型的缺点，不能再随便存了
        List list = new ArrayList<Animal>();
        //
        Cat c = new Cat();
        Bird b = new Bird();
        // 将对象添加到集合中
        list.add(c);
        list.add(b);

        // 遍历
        // 表示迭代器迭代的时animal类型
        Iterator<Animal> it = list.iterator();
        while (it.hasNext()) {
            // 使用泛型之后，每一次迭代返回的是Animal类型
            Animal i = it.next();
        }


//        while (it.hasNext()) {
//            Object o = it.next();
//            if(o instanceof Cat){
//                Cat cat = (Cat) o;
//                cat.catchMouse();
//            }else{
//                Bird bird = (Bird)o;
//                bird.fly();
//            }
//        }
    }
}


class Animal {
}

class Cat extends Animal {
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}


class Bird extends Animal {
    public void fly() {
        System.out.println("鸟儿飞翔");
    }
}
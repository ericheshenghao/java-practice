package com.company.chapter19.数组;

/*
数组储存的类型为：引用数据类型
 */
public class Test07 {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1, a2};

        // 对Animal数组进行遍历
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
            Animal a = animals[i];
            a.move();
            animals[i].move();
        }

        // Animal 数组中只能存放animal类型
        // 可以存放子类
        Animal[] ans = new Animal[3];
        ans[0] = new Animal();
        ans[1] = new Cat();
        ans[2] = new Bird();
        //
        Animal[] anis = {new Cat(), new Bird()};
        for (int i = 0; i < anis.length; i++) {
            System.out.println(anis);
            anis[i].move();
            if (anis[i] instanceof Cat) {
                Cat cat = (Cat) anis[i];
                cat.catchMouse();
            } else {
                Bird bird = (Bird) anis[i];
                bird.sing();
            }
        }

    }
}

class Animal {
    public void move() {
        System.out.println("Animal move.....");
    }
}

class Cat extends Animal {
    @Override
    public void move() {
        super.move();
    }

    // 特有方法
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        super.move();
    }

    // 特有方法
    public void sing() {
        System.out.println("唱歌");
    }
}
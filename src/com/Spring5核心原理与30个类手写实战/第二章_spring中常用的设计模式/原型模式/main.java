package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.原型模式;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setName("jeddy");
        concretePrototypeA.setAge(18);
        List<String> objects = new ArrayList<>();
        concretePrototypeA.setHobbies(objects);


        // 创建client对象
        Client client = new Client(concretePrototypeA);
      ConcretePrototypeA concretePrototypeA1=  (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeA1);
        System.out.println("对象地址比较"+(concretePrototypeA==concretePrototypeA1));
        System.out.println("对象内地址比较"+(concretePrototypeA.getHobbies()==concretePrototypeA1.getHobbies()));
    }
}

  interface Prototype{
    Prototype clone();
}


class  ConcretePrototypeA implements Prototype{
    private int age;
    private String name;
    private List hobbies;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setHobbies(this.hobbies);
        concretePrototypeA.setName(this.name);
        return concretePrototypeA;
    }
}

class Client{
    private Prototype prototype;
    public Client(Prototype prototype){
        this.prototype =prototype;
    }

    public Prototype startClone(Prototype concretePrototype){
        return concretePrototype.clone();
    }
}
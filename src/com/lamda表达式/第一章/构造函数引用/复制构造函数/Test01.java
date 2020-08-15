package com.lamda表达式.第一章.构造函数引用.复制构造函数;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Person before = new Person("张三");
//        List<Person> people = Stream.of(before)
//                .collect(Collectors.toList());
//        Person after = people.get(0);
//
//        System.out.println(before==after);
//        before.setName("李四");
//        // before发生变化后，afte也变化了
//        System.out.println(after.getName());
//        System.out.println("李四".equals(after.getName()));
        
        //===============================================
        List<Person> people = Stream.of(before)
                .map(Person::new)
                .collect(Collectors.toList());
        Person after= people.get(0);
        System.out.println(before==after);
        System.out.println(before.equals(after));
        
        before.setName("王五");
        System.out.println(before.equals(after));

        
    }
}


class Person{
    private String name;

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        return  ((Person)  obj).getName() ==this.getName();
    }

    Person(Person p){
        this.name=p.name;
    }

    Person(String p){
        this.name=p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
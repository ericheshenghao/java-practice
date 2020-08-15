package com.lamda表达式.第一章.构造函数引用.可变参数构造函数;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        List<Person> collect = names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());

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

    Person(String... name){
        this.name= Arrays.stream(name).collect(Collectors.joining(" "));
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


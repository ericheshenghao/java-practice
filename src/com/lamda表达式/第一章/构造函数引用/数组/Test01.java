package com.lamda表达式.第一章.构造函数引用.数组;

import java.util.Arrays;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        Person[] people = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);

    }
}

class Person{
    private String name;

    Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


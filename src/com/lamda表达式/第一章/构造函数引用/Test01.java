package com.lamda表达式.第一章.构造函数引用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三"));
        personList.add(new Person("李四"));

        List<String> collect = personList.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());

        List<String> collect1 = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());


        List<String> names = Arrays.asList("张三", "李四", "王五");

        List<Person> people = names.stream().map(name -> new Person(name))
                .collect(Collectors.toList());

        List<Person> people1 = names.stream().map(Person::new)
                .collect(Collectors.toList());


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


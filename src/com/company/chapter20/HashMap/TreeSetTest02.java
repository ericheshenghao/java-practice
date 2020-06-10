package com.company.chapter20.HashMap;

import java.util.TreeSet;

/*
自定义类型可以排序吗
.Person cannot be cast to java.lang.Comparable

没有实现Comparable接口
 */
public class TreeSetTest02 {
    public static void main(String[] args) {
        Person p1 = new Person(32);
        Person p2 = new Person(22);
        Person p3 = new Person(312);
        Person p4 = new Person(32);

        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        personTreeSet.add(p4);

        for (Person p : personTreeSet
        ) {
            System.out.println(p);
        }
    }
}

class Person {
    Integer age;

    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
package com.company.chapter20.HashMap;

import java.util.TreeSet;

/*
自定义类型可以排序吗
.Person cannot be cast to java.lang.Comparable

没有实现Comparable接口
 */
public class TreeSetTest04 {
    public static void main(String[] args) {
        Person1 p1 = new Person1(32);
        Person1 p2 = new Person1(22);
        Person1 p3 = new Person1(312);
        Person1 p4 = new Person1(32);

        TreeSet<Person1> personTreeSet = new TreeSet<>();
        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        personTreeSet.add(p4);

        for (Person1 p : personTreeSet
        ) {
            System.out.println(p.getAge());
        }
    }
}

class Person1 implements Comparable<Person1> {
    Integer age;

    public Person1() {
    }

    public Person1(Integer age) {
        this.age = age;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 需要再这个方法离写比较的逻辑
    // 实现compareTo方法
    // 按照年龄升序或降序
    @Override
    public int compareTo(Person1 o) {
//        // this是C1
//        // c是C2
//        // c1和c2比较，就是this和c比较
//        int age1 = this.age;
//        int age2 = o.age;
//        if(age1==age2){
//            return 0;
//        }else if(age1>age2){
//            return 1;
//        }else{
//            return  -1;
//        }
        return this.age - o.age;
    }

    @Override
    public String
    toString() {
        return "Person1{" +
                "age=" + age +
                '}';
    }
}
package com.company.chapter20.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
先调用key的hashcode方法，然后调用equals方法
equals有可能调用，也有可能不调用了
  拿put（k，v）举例子，什么时候euqals不会调用
   k.hashcode()方法返回哈希值，哈希值转换成数组下标，数组下标如果是空，equals不需要执行，
   拿get（k），什么时候equals不会调用
    组下标如果是空，equals不需要执行，
 2、如果一个类的equals方法重写了，那么hashcode必须重写
 并且equals方法返回的如果是true，hashcode方法返回的值必须一样

 4、 放在hashmap集合key部分的，以及放在hashset集合中的元素，需要同时重写hashcode方法和equals
 */
public class Test02 {
    public static void main(String[] args) {
        Student s1 = new Student("zhansan");
        Student s2 = new Student("zhansan1");

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        // 重写equals方法之前是false

        // s1.equals(s2);结果为true 按说hashmap只能放一个，因为我们没有重写hashcode()
        Set<Student> studentSet = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Student s = new Student("zhansan3" + i);
            studentSet.add(s);
        }
        studentSet.add(s1);
        studentSet.add(s2);
        System.out.println(studentSet.size());
    }
}

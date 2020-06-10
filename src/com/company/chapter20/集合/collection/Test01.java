package com.company.chapter20.集合.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 collection常用方法
 可以存储Object的子类型
 2、常用方法
   add(e)
   int size()
   void clear()
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建一个集合对象
        // 多态多态！！！ 
        // 父类型接口Collection 子类型的一个实现
        Collection collection = new ArrayList();
        // 测试接口中的常用方法
        // 自动装箱 放进去了一个对象的内存地址 
        collection.add(100); // Integer x = new Integer(100);

        collection.add(new Student());
        collection.clear();
        System.out.println(collection.size());

        collection.add("hello"); // 对象的内存地址放到了集合当中
        collection.add("绿巨人");
        collection.add(new Student());
        System.out.println(collection.contains("hello"));
        collection.remove("hello");
        System.out.println(collection.isEmpty());
        Object[] o = collection.toArray();
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
        }

    }
}

class Student {
}

package com.company.chapter20.集合.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
关于集合元素得remove
//java.util.ConcurrentModificationException
当集合结构发生变化，迭代器没有变化

迭代器迭代的时候会参照这个快照进行迭代

 */
public class Test06 {
    public static void main(String[] args) {
        // 创建集合
        Collection c = new ArrayList();
        // 在这获取迭代器，指向的是没有元素状态下的迭代器

        c.add(1);
        c.add(2);
        c.add(3);

        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
        Collection c1 = new ArrayList();
        // 在这获取迭代器，指向的是没有元素状态下的迭代器

        c1.add("abc");
        c1.add("def");
        c1.add("ghj");
        Iterator it1 = c1.iterator();
        while (it1.hasNext()) {
            Object obj = it1.next();
            // 删除之后，集合的结构出现了变化，应该重新去获取迭代器
            it1.remove();
            // 通过迭代器删除不会出问题
            // 如果直接操作元数据删除就会报错
            // 迭代器删除时会自动更新迭代器，更新集合
//            c1.remove(obj);
            System.out.println(obj);
        }

        System.out.println(c1.size());

    }
}

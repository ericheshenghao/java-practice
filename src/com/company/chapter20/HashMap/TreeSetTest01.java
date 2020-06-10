package com.company.chapter20.HashMap;

import java.util.TreeSet;

/*
1、TreeMap集合底层是一个二叉树
2、放到TressSet集合中的元素，等同于放在TreeMao集合的key部分
3、无序不可重复，可以自动排序
可排序集合

 */
public class TreeSetTest01 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("zhangsan");
        ts.add("aaaa");


        for (String s : ts
        ) {
            System.out.println(s);
        }

        TreeSet<Integer> ts1 = new TreeSet<>();
        ts1.add(1);
        ts1.add(3);
        ts1.add(4);
        ts1.add(21);
        ts1.add(1);
        ts1.add(4);
        ts1.add(1111);
        ts1.add(1123);
    }
}

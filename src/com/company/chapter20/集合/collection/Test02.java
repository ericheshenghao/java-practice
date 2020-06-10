package com.company.chapter20.集合.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
迭代专题
 */
public class Test02 {
    public static void main(String[] args) {
        // 注意：所有collection通用的一种方式，在Map中不能使用

        Collection c = new HashSet();
        // 添加元素
        c.add("abc");
        c.add("def");
        c.add(100);
        c.add(new Object());
        // 拿到迭代器对象
        Iterator it = c.iterator();
        // 遍历输出
        /*
        以下两个方法是迭代器中的方法
          nest（）
          hasNest（）  
         */
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}

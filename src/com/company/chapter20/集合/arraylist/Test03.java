package com.company.chapter20.集合.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
构造方法
 */
public class Test03 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList(100);


        // 创建一个HashSet集合
        Collection c = new HashSet();
        c.add(100);
        c.add(200);
        c.add(900);
        c.add(50);

        List list3 = new ArrayList(c);

        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));


        }

    }
}

package com.company.chapter20.HashMap;

import java.util.*;

/*
集合工具类
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 线程安全的
        Collections.synchronizedList(list);

        // 排序
        list.add("abc");
        list.add("sss");
        list.add("eee");

        Collections.sort(list);

        for (String s : list
        ) {
            System.out.println(s);
        }

        List<WuGui> list1 = new ArrayList<>();
        list1.add(new WuGui(100));
        list1.add(new WuGui(8000));
        Collections.sort(list1);

        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingsolf");
        // 将set集合装换成list集合
        List<String> list2 = new ArrayList<>(set);
        Collections.sort(list2);
        // 这种方式也就可以
//        Collections(集合，比较器)


    }
}

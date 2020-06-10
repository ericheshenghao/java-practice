package com.company.chapter20.HashSet;

import java.util.Set;
import java.util.TreeSet;

/*
Treeset 无序不可重复，但是储存的元素可以自动按照大小顺序排序
可排序集合

 */
public class Test02 {
    public static void main(String[] args) {
        Set<String> strs = new TreeSet<>();

        strs.add("A");
        strs.add("Z");
        strs.add("1");
        strs.add("D");
        strs.add("c");
        strs.add("K");
        strs.add("g");
        // 遍历
        for (String s : strs
        ) {
            System.out.println(s);
        }

    }
}

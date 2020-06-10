package com.company.chapter20.单向链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        // linkedlist底层也是有下标的
        // arraylist之所以检索效率较高，不是单纯的因为下标的原因，。是因为底层数组发挥的作用
        // LinkedList集合照样有下标，但是检索某个元素的时候效率较低，因为只能遍历寻找
        // 随机增删比较多时，使用LinkedList
        // 检索查找效率较低'
        // 加元素都是往末尾添加，所以ArrayList用的比较多
        // arraylist不是线程安全的
        // 讲arraylist集合转成线程安全的
        // 使用
        List ls = new LinkedList();
        ls.add("a");
        ls.add("b");
        ls.add("c");

        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }

        List ls1 = new ArrayList();
        // 变成线程安全
        Collections.synchronizedList(ls1);
        ls1.add("a");
        ls1.add("b");
        ls1.add("c");
    }
}

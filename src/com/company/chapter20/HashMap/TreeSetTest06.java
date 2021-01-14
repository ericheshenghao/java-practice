package com.company.chapter20.HashMap;


import java.util.Comparator;
import java.util.TreeSet;

/*
TreeSet元素可排序的第二种方式
使用比较器的方式
    第一种：实现接口
    第二种：传一个比较器对象
    选哪个，
    规则不变用接口
    比较规则有多个，且需要频繁切换，使用Comparator接口
 */
public class TreeSetTest06 {
    public static void main(String[] args) {
        // 创建集合，需要使用这个比较器
        TreeSet<WuGui> treeSet = new TreeSet<>(new WuguiConparator());

        treeSet.add(new WuGui(200));
        treeSet.add(new WuGui(100));
        treeSet.add(new WuGui(50));
        treeSet.add(new WuGui(230));

        for (WuGui w : treeSet
        ) {
            System.out.println(w);
        }

        //匿名内部类
        TreeSet<WuGui> treeSet1 = new TreeSet<>(new Comparator<WuGui>() {
            @Override
            public int compare(WuGui o1, WuGui o2) {
                return 0;
            }
        });

    }
}


class WuGui implements Comparable {
    int age;

    public WuGui(int age) {
        this.age = age;
    }

    public WuGui() {
    }

    @Override
    public String toString() {
        return "小乌龟{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

//单独比较器
// 比较实现java.util.Comparator接口
class WuguiConparator implements Comparator<WuGui> {

    @Override
    public int compare(WuGui o1, WuGui o2) {
        // 指定比较规则
        return o1.age - o2.age;
    }
}
package com.company.chapter20.HashMap;

import java.util.TreeSet;

public class TreeSetTest05 {
    public static void main(String[] args) {
        TreeSet<Vip> vips = new TreeSet<>();
        vips.add(new Vip("zhangsn", 20));
        vips.add(new Vip("khangsan", 20));
        vips.add(new Vip("ahansan", 12));
        vips.add(new Vip("ghagsan", 11));
        vips.add(new Vip("yangsan", 13));

        for (Vip vip : vips
        ) {
            System.out.println(vip.age + vip.name);
        }
    }
}


class Vip implements Comparable<Vip> {
    String name;
    int age;

    @Override
    public String toString() {
        return "Vip{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Vip(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Vip o) {
        if (this.age == o.age) {
            //年龄相等时按照名字排序
            //可以直接比较
            return this.name.compareTo(o.name);
        } else {
            return this.age - o.age;

        }

    }
}
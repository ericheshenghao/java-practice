package com.company.chapter20.Map;

import java.util.HashSet;
import java.util.Set;

public class Test02 {
    // 静态内部类
    private static class InnerClass {

        // 静态方法
        public static void m1() {
            System.out.println("静态内部类的m1方法");
        }

        public void m2() {
            System.out.println("实例方法");
        }
    }

    public static void main(String[] args) {
        Test02.InnerClass.m1();

        // 创建静态内部类对象
        Test02.InnerClass cls = new Test02.InnerClass();
        cls.m2();

        //给一个set集合
        // 存储的是Test01.InnerClass类型
        Set<InnerClass> set = new HashSet<>();
        //
        Set<MyMap.MyEntry<Integer, String>> set2 = new HashSet<>();

    }
}


class MyMap {
    public static class MyEntry<K, V> {
    }
}

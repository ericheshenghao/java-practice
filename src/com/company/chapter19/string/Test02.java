package com.company.chapter19.string;

public class Test02 {
    public static void main(String[] args) {
        String s1 = "hello";
        // hello储存在方法区的字符串常量中，已经存在，指向的地址是一样的，所以这里是true
        String s2 = "hello";
        // ==比较的是内存地址
        System.out.println(s1 == s2);

        String x1 = new String("h1");
        String x2 = new String("h1");
        // 这里比较的其实是两个对象的内存地址。
        System.out.println(x1 == x2);
        System.out.println(new String("h1") == new String("h2"));
        // 双等号比较不保险，所以要使用equals
        // String 类已经重写额equals方法，所以可以直接调用。
        System.out.println(x1.equals(x2));
        // 因为"h1"是一个String字符串对象，只要是对象都能调用方法
        System.out.println("h1".equals(x2));
    }
}

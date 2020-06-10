package com.company.chapter19.string;

/*
分析一下程序，一共创建了几个对象
 */
public class Test03 {
    /*
    一共创建了三个对象，方法区字符串常量池中有一个
    堆内存中有两个String对象
    一共三个
     */
    public static void main(String[] args) {
        String x1 = new String("hello");
        String s2 = new String("hello");
    }
}

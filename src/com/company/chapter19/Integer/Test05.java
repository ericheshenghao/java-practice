package com.company.chapter19.Integer;

/*
支持自动拆箱和自动装箱
// 方便编程
 */
public class Test05 {
    // 自动装箱
    // int---Integer
    Integer x = 100;
    // 自动拆箱
    // Integer---int
    int y = x;


    public static void main(String[] args) {
        // z是一个引用，保存了一个对象的内存地址
        Integer z = 1000;  // 等同于L:Integer z = new Integer(1000);
        // 这里有自动装箱和拆箱机制
        // 1.5之前报错，现在可以这样写
        System.out.println(z + 1);


        Integer a = 128;  // a保存内存地址指向对象
        Integer b = 128;  // b保存内存地址指向对象
        System.out.println(a == b);
    }
}

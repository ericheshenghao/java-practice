package com.company.chapter20.反射;

import java.util.Date;

/*
 三种方式获取 lang.class 实例
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        1、静态方法
        2、方法的参数是一个字符串
        3、字符串需要的是一个完整类名
        4、完整类名必须带有包名
         */

        Class c1 = Class.forName("java.lang.String"); // c1代表string.class文件
        Class c2 = Class.forName("java.util.Date");
        Class c3 = Class.forName("java.lang.Thread");

        /*
        getclass()方法获取
         */
        String s = "abc";
        Class x = s.getClass(); //x 代表string。class字节码文件
        // == 判断的是内存的地址
        System.out.println(c1 == x);

        // 第三种方式、都有class属性
        Class z = String.class;
        Class k = Date.class;
    }
}

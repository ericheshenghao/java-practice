package com.company.chapter18;

// string 已经重新写了构造方法
// 引用和数据类型旁段相等使用equals
public class Test03 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello2";
        // 既然String 是一个类，那么一定存在构造方法。
        String s3 = new String("Text");
        String s4 = new String("Text");
        System.out.println(s3 == s4);
        // 比较两个字符串能不能使用双等号。不能；

        System.out.println(s3.equals(s4));

        System.out.println(s1.toString());
    }
}

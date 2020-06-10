package com.company.chapter19.Integer;

public class Test06 {
    public static void main(String[] args) {
        // 字符串不可变是什么意思
        // 是说引号里面的字符串对象一旦创建不可变
        String s = "abc";
        // s变量是可以指向其他对象的
        // 说的是abc这个对象不可变
        s = "xyz";

        StringBuffer stringBuffer;
    }
}

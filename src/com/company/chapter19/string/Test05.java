package com.company.chapter19.string;

/*
 实际开发中，如果需要字符串的频拼接，会有什么问题，
  因为java 中的字符串是不可变的，每一次的拼接都会产生新的字符出啊你
  这样会占用大量的方法区内存，造成内存空间的浪费
  String s = "doc";
  s+="hello";
  创建了三个对象
  */
public class Test05 {
    public static void main(String[] args) {
        String s = "";
        // 这样会给java的字符串常量池带来很大的压力
        for (int i = 0; i < 100; i++) {
            s += i;
            System.out.println(s);
        }
    }
}

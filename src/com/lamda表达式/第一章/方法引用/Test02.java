package com.lamda表达式.第一章.方法引用;


import java.util.stream.Stream;

public class Test02 {
    // 静态方法中使用
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
}

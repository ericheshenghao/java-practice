package com.lamda表达式.第二章.归约操作.二元运算符.拼接字符串;

import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        String reduce = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);
        System.out.println(reduce);
    }
}

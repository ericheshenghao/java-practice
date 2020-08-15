package com.lamda表达式.第一章.方法引用;

import java.util.stream.Stream;

/**
 * 使用方法引用在String上调用length方法
 */
public class Test04 {
    public static void main(String[] args) {
        Stream.of("this","is","a","stream","of","strings")
                .map(String::length)
                .forEach(System.out::println);

        // 等效表达式
        Stream.of("this","is","a","stream","of","strings")
                .map(s->s.length())
                .forEach(x->System.out.println(x));
    }

}

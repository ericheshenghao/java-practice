package com.lamda表达式.第二章.归约操作.二元运算符;

import java.util.stream.Stream;

/**
 * 利用二元运算符进行归约操作
 */
public class Test01 {
    public static void main(String[] args) {
        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}

package com.lamda表达式.第二章.归约操作.获取元素数量;

import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        long count = Stream.of(1, 3, 4, 5, 6, 7, 8, 10, 123)
                .count();
        System.out.println(count);
    }
}

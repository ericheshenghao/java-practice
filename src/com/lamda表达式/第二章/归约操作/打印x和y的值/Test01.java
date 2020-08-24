package com.lamda表达式.第二章.归约操作.打印x和y的值;

import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {
        int i = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d,y=%d%n", x, y);
                    return x + y;
                }).orElse(0);
        System.out.println(i);
    }
}

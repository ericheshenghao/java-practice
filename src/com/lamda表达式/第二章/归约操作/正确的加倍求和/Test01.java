package com.lamda表达式.第二章.归约操作.正确的加倍求和;

import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {
        int reduce = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + 2 * y);
        System.out.println(reduce);
    }
}

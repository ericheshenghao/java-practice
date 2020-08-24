package com.lamda表达式.第二章.查找流的第一个元素.并行流中使用firstEven;

import java.util.Optional;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Optional<Integer> first = Stream.of(1, 2, 3, 4, 5, 7, 8)
                .parallel()
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(first.get());
    }
}

package com.lamda表达式.第一章.方法引用;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,5,6).forEach(System.out::println);

        Consumer<Integer> printer = System.out::println;
        Stream.of(1,2,3,4,5,6).forEach(printer);
    }
}

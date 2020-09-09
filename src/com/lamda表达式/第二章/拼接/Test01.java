package com.lamda表达式.第二章.拼接;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        concat();
    }
    public static void concat() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        List<String> collect = Stream.concat(first, second)
                .collect(Collectors.toList());
        List<String> strings = Arrays.asList("a", "b", "c", "X", "Y", "Z");
        System.out.println(collect.equals(strings));

    }
}

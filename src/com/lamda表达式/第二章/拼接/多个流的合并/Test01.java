package com.lamda表达式.第二章.拼接.多个流的合并;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        Stream<String> third = Stream.of("alpha", "beta", "gamma");
        Stream<String> fouth = Stream.empty();

        List<String> strings = Stream.of(first, second, third, fouth)
                .flatMap(Function.identity())
                .collect(Collectors.toList());
        List<String> strings1 = Arrays.asList("a", "b", "c", "X", "Y", "Z", "alpha", "beta", "gamma");
        System.out.println(strings.equals(strings1));
    }
    
}

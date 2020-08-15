package com.lamda表达式.第二章.流的创建;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        String collect = Stream.of("ss", "dd", "cc").collect(Collectors.joining(", "));
        System.out.println(collect);

        String[] munsters = {"ss", "dd", "cc"};

        String collect1 = Arrays.stream(munsters).collect(Collectors.joining(","));

    }
}

package com.lamda表达式.第二章.归约操作;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Test01 {
    public static void main(String[] args) {
        String[] s = "this is a array of strings".split(" ");
        long count = Arrays.stream(s)
                .map(String::length)
                .count();
        int sum = Arrays.stream(s)
                .mapToInt(String::length)
                .sum();

        OptionalDouble average = Arrays.stream(s)
                .mapToInt(String::length)
                .average();
        OptionalInt max = Arrays.stream(s)
                .mapToInt(String::length)
                .max();
    }
}

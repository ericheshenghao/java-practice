package com.lamda表达式.第一章.方法引用;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("this", "is", "a", "lsit", "of", "strings");
        List<String> collect = list.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        List<String> collect1 = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}

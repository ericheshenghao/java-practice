package com.lamda表达式.第二章.归约操作.获取元素数量.对根据长度划分的字符串计数;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list");
        Map<Boolean, Long> collect = strings.stream().collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.counting()));
        collect.forEach((k,v)->System.out.printf("%5s: %d%n",k,v));
        //false: 1
        // true: 3
    }
}

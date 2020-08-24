package com.lamda表达式.第二章.流的创建.从集合创建流;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("张三", "李四", "王五");
        String collect = strings.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}

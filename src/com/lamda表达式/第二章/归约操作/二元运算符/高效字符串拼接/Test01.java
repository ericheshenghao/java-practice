package com.lamda表达式.第二章.归约操作.二元运算符.高效字符串拼接;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        String reduce = Stream.of("this", "is", "a", "list")
                .collect(()->new StringBuilder(),
                        (sb,str)->sb.append(str),
                        (sb1,sb2)->sb1.append(sb2)).toString();

        // 简化版本
        Stream.of("this", "is", "a", "list").collect(StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append).toString();
        // 最简单
        String collect = Stream.of("this", "is", "a", "list")
                .collect(Collectors.joining(""));
        System.out.println(collect);
    }
}

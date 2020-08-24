package com.lamda表达式.第二章.流的创建.range和rangclosed方法;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Test01 {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Long> collect1 = LongStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect1);
             
    }
}

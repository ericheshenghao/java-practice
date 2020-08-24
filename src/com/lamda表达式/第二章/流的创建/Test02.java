package com.lamda表达式.第二章.流的创建;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 利用iterate方法创建流
 */
public class Test02 {
    public static void main(String[] args) {
        List<BigDecimal> collect = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<LocalDate> collect1 = Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect1);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
}

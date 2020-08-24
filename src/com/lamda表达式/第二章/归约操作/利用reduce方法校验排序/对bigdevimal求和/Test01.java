package com.lamda表达式.第二章.归约操作.利用reduce方法校验排序.对bigdevimal求和;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {

        Integer reduce1 = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19).stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce1);

        BigDecimal reduce = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.valueOf(2)))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
        System.out.println(reduce);
    }
}

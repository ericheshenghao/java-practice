package com.lamda表达式.第二章.归约操作.二元运算符.查找最大值;

import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Integer reduce = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max);
        
        System.out.println(reduce);
    }
}

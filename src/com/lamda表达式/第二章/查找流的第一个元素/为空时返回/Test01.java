package com.lamda表达式.第二章.查找流的第一个元素.为空时返回;

import java.util.Optional;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Optional<Integer> first = Stream.of(1, 2, 3, 4, 5, 1, 7, 8)
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(first);
        //Optional.empty
    }
    
}

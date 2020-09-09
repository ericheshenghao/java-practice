package com.lamda表达式.第四章.实现Collector接口;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {

    }

    public List<String> evenLengthStrings(String...strings){
        List<String> collect = Stream.of(strings)
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
        return collect;
    }
}

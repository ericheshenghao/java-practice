package com.lamda表达式.第二章.function接口;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

public class Test01 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("mail", "wash", "kaylee", "inara", "zoe","CC");
        List<Integer> nameLength = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }).collect(Collectors.toList());

        List<Integer> nameLength1 = names.stream()
                .map(
                        s->s.length()
                ).collect(Collectors.toList());

         nameLength = names.stream()
                .map(s -> s.length()).collect(Collectors.toList());

        nameLength = names.stream()
                .map(String::length).collect(Collectors.toList());
    }
}

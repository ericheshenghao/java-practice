package com.lamda表达式.第二章.function包;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Test01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "lsit", "of", "strings");

        List<Integer> integers = Arrays.asList(1,23,45,55);
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
//                System.out.println(s);
            }
        });



//        strings.forEach(s->System.out.println(s));
//        strings.forEach(System.out::println);
    }
}


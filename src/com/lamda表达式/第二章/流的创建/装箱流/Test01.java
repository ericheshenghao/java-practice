package com.lamda表达式.第二章.流的创建.装箱流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        List<String> collect = Stream.of("this", "is", "a", "list")
                .collect(Collectors.toList());

        List<Integer> collect1 = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> collect2 = IntStream.of(1, 2, 3, 4, 5)
               .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());


        IntStream.of(1, 2, 3, 4, 5)
                .collect(ArrayList<Integer>::new,ArrayList::add,ArrayList::addAll);

        int[] ints = IntStream.of(1, 2, 3, 4, 5).toArray();
    }
}

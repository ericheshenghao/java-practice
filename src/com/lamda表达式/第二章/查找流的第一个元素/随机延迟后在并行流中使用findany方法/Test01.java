package com.lamda表达式.第二章.查找流的第一个元素.随机延迟后在并行流中使用findany方法;

import java.util.Optional;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        Optional<Integer> any = Stream.of(1, 2, 3, 4, 5, 56, 7, 8)
                .unordered()
                .parallel()
                .map(Test01::delay)
                .findAny();

        System.out.println(any.get());

        Optional<Integer> any1 = Stream.of(1, 2, 3, 4, 5, 56, 7, 8)
                .unordered()
                .map(Test01::delay)
                .findAny();


        System.out.println(any1.get());


    }

    public static Integer delay(Integer n){
        try {
            Thread.sleep((long) Math.random()*100);

        }catch (Exception e){

        }

        return n;
    }
}

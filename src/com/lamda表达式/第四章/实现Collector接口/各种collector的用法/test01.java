package com.lamda表达式.第四章.实现Collector接口.各种collector的用法;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test01 {
    public static void main(String[] args) {
//        R container = collector.supplier.get();
//        for(T t :data){
//            collector.accumulator().accept(container,t);
//        }
//        return collector.finisher().apply(container);

    }
    public SortedSet<String> oddLengthStringSet(String...strings){
        Collector<String, ?, SortedSet<String>> intolist = Collector.of(TreeSet<String>::new,
                SortedSet::add,
                (left, right) -> {
            left.addAll(right);
            return left;
        }, Collections::unmodifiableSortedSet);

        return Stream.of(strings)
                .filter(s->s.length()%2!=0)
                .collect(intolist);

    }
}

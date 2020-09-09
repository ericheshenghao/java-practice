package com.lamda表达式.第四章.利用比较器实现排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

public class test01 {
    private List<String> sampleStrings = Arrays.asList("this","is","a","list","of","strings");

    public List<String> defaultSort(){
        Collections.sort(sampleStrings);  // java1.7默认排序
        return sampleStrings;
    }
    public List<String> defaultSortUsingStreams(){
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());  // java1.8默认排序
    }

    public List<String> lengthSortUsingSorted(){
        return sampleStrings.stream()
                .sorted((s1,s2)->s1.length()-s2.length())
                .collect(Collectors.toList());  //使用lambda表达式作为Comparator 根据长度进行排序
    }

    public List<String> lengthSortUsingComparator(){
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList()); // 使用Comparator.comparingInt方法
    }

    public List<String> lengthSortThenAlphaSort(){
        return sampleStrings.stream()
                .sorted(comparing(String::length)
                .thenComparing(naturalOrder())
                ).collect(Collectors.toList());

    }

}

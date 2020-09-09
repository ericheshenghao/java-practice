package com.lamda表达式.第四章.分区与分组;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test01 {
   static List<String> strings = Arrays.asList("this","is","a","long","list",
            "of","strings","to","user","as","a","demo");

   static Map<Boolean,List<String>> lengtMap =strings.stream()
            .collect(Collectors.partitioningBy(s->s.length()%2==0));

   static  Map<Integer,List<String>> lengthMap = strings.stream()
           .collect(Collectors.groupingBy(String::length));

   Map<Boolean,Long> numberLengthMap = strings.stream()
           .collect(Collectors.partitioningBy(s->s.length()%2==0,Collectors.counting()));

    public static void main(String[] args) {
        lengthMap.forEach((k,v)->System.out.printf("%d: %s%n",k,v));
    }
}

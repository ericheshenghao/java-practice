package com.lamda表达式.第二章.归约操作.利用reduce方法校验排序.根据长度对字符串排序;

import com.sun.xml.internal.ws.policy.jaxws.SafePolicyReader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list");
        List<String> collect = strings.stream().sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(collect);

        // 测试排序是否正确
        collect.stream().reduce((pre,curr)->{
            if (pre.length()<= curr.length()) System.out.println("true");
            return curr;
        });
    }
}

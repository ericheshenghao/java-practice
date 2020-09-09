package com.lamda表达式.第五章.流式操作方法引用的相关问题;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Objects类 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", null, "is", "a", null, "list", "of", "strings", null);
        List<String> collect = strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    public <T> List<T> getNonNullElements(List<T> list){
        List<T> collect = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return collect;
    }


}

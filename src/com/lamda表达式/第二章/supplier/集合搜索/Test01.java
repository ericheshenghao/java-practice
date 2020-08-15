package com.lamda表达式.第二章.supplier.集合搜索;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("mail", "wash", "kaylee", "inara", "zoe","CC");

        Optional<String> first = names.stream().filter(name -> name.startsWith("H"))
                .findFirst();
        System.out.println(first);
        System.out.println(first.orElse("None"));
        System.out.println(first.orElse(String.format("No result found in %s",names.stream()
                .collect(Collectors.joining(", ")))));
        System.out.println(first.orElseGet(()-> String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));
    }
}

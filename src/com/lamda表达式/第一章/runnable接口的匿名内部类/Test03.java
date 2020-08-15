package com.lamda表达式.第一章.runnable接口的匿名内部类;

import java.io.File;
import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        File file = new File("./src/com/lamda表达式/runnable接口的匿名内部类/");
        String[] list = file.list((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(list));
    }
}

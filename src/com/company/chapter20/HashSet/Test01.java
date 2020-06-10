package com.company.chapter20.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        Set<String> strs = new HashSet<>();

        strs.add("hrllo");
        strs.add("hhs");
        strs.add("1");
        strs.add("3");

        for (String s : strs
        ) {
            System.out.println(s);
        }
    }
}

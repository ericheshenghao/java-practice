package com.lamda表达式.第二章.predicate;

import com.company.chapter20.线程安全.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test01 {
    public static  final  Predicate<String> LENGTH_FIVE = s->s.length()==5;
    public static final Predicate<String> START_WITH_S =s -> s.startsWith("S");


    public static void main(String[] args) {

    }

    public String getNamesOflength(int length,String... names){
        return Arrays.stream(names).filter(s->s.length()==length)
                .collect(Collectors.joining(", "));
    }

    public String getNamesStartingWith(String s,String... names){
        return Arrays.stream(names)
                .filter(str->str.startsWith(s))
                .collect(Collectors.joining(", "));
    }

    public  String getNamesSatisfyingCondition(Predicate<String> condition,String...names){
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }

}

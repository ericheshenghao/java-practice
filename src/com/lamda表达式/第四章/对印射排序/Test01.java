package com.lamda表达式.第四章.对印射排序;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    static String dictionary= "usr/share/dict/words";
    public static void main(String[] args) {

        try(Stream<String > lines = Files.lines(Paths.get(dictionary))){
        lines.filter(s -> s.length()>20)
                .collect(Collectors.groupingBy(String::length,Collectors.counting()))
                .forEach((len,num)->System.out.printf("%d: %d%n",len,num));
       }catch(Exception e){
           e.printStackTrace();
       };
    }
}

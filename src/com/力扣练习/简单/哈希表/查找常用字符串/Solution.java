package com.力扣练习.简单.哈希表.查找常用字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> commonChars(String[] A) {
        ArrayList<String> integers = new ArrayList<>();
        List<String> collect = Arrays.stream(A).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        for (int i = 0; i < collect.get(0).length(); i++) {
            boolean flag = true;
            for (int j = 0; j < A.length; j++
                 ) {
                if (!A[j].contains(collect.get(0).substring(i,i+1))){
                    flag=false;
                }else{

                    A[j]= A[j].replaceFirst(collect.get(0).substring(i, i + 1),"");
                }
            }

            if(flag==true){
                integers.add(collect.get(0).substring(i,i+1));
            }
        }




        return  integers;
    }

    public static void main(String[] args) {
       String[] strings = {"bc","ac","dc","cd","ccc","dbc","cb","cac"};
        Solution solution = new Solution();
        solution.commonChars(strings);
    }
}
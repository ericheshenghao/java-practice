package com.力扣练习.笔试.排序题.快速排序;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void quickSort(List<Integer> items) {

        if(items.size()>1){
            List<Integer> smaller=new ArrayList<>();
            List<Integer> same=new ArrayList<>();
            List<Integer> larger=new ArrayList<>();

            Integer chosen = items.get(items.size() / 2);
            for (Integer i : items) {
                if(i<chosen){
                    smaller.add(i);
                }else if(i>chosen){
                    larger.add(i);
                }else {
                    same.add(i);
                }
            }

            quickSort(smaller);
            quickSort(larger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,2,5,6};
        List<Integer> items = Arrays.stream(arr).boxed().collect(Collectors.toList());
        quickSort(items);

       items.forEach(System.out::println);
    }

}

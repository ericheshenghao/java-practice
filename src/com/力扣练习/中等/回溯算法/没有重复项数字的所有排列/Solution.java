package com.力扣练习.中等.回溯算法.没有重复项数字的所有排列;


import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        List<Integer> array= Arrays.stream(num).boxed().collect(Collectors.toList());
        ArrayList<ArrayList<Integer>> rev=  new ArrayList<>();
        trace(array,new ArrayList<Integer>(),num.length,rev);
        return rev;
    }
    public void trace(List<Integer> list,List<Integer> temp,int n,ArrayList<ArrayList<Integer>> rev){
        if(n<=0){
            rev.add((ArrayList<Integer>) temp);
            return;
        }
        --n;
        for(int i=0;i<list.size();i++){
           List<Integer> pre = new ArrayList<>();
           pre.addAll(temp);
            List<Integer> pro = new ArrayList<>();;
            pro.addAll(list);
            temp.add(list.get(i));
            list.remove(list.get(i));
            trace(list,temp,n,rev);
            temp = pre;
            list=pro;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> permute = solution.permute(new int[]{1, 2});
        for (ArrayList<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
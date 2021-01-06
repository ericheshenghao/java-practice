package com.难度归档.简单.数组.两数之和.回溯法;

import java.util.*;


public class Solution {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    List<Integer> res;
    boolean end;
    public int[] twoSum (int[] numbers, int target) {
        // write code here

        List<Integer> rev =  new ArrayList<Integer>();
        trace(numbers,target,rev,0);

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void trace(int[] numbers,int target,List<Integer> rev,int start){
        if(target==0 && rev.size()==2){
            this.res =rev;
            end =true;
            return;
        }
        if(end || rev.size()==2|| target<0)  return;

        for(int i=start;i<numbers.length;i++){
            List<Integer> temp= new ArrayList<Integer>();
            temp.addAll(rev);
            rev.add(i+1);
            trace(numbers,target-numbers[i],rev,start+1);
            rev =temp;
        }
    }

}
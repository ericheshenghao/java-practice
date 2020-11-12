package com.力扣练习.简单.数组.独一无二的出现次数;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author : heshenghao
 * @date : 10:26 2020/10/28
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int left=0;
        int right=0;

        Set<Integer> set = new HashSet<>();

        while(right<arr.length){
            right+=1;
            if(right==arr.length){
                boolean add=  set.add(right-left);
                if(!add) return false;
                else return true;
            }
            if(arr[left]!=arr[right]){
                boolean add=  set.add(right-left);
                if(!add) return false;
                left=right;
            }
        }

        return true;
    }
}
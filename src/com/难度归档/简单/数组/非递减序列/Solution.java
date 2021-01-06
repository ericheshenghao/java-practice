package com.难度归档.简单.数组.非递减序列;

import java.util.ArrayDeque;

class Solution {
  ArrayDeque deque =  new ArrayDeque<Integer>();
 

    public boolean checkPossibility(int[] nums) {
        for (int i = 0; i <nums.length-1 ; i++) {

            if(nums[i]>nums[i+1]){
                deque.push(1);
            }
        }
       return deque.size()<2;

    }

    public static void main(String[] args) {
        int[] ints = {3,4, 2, 3};
        Solution solution = new Solution();
        boolean b = solution.checkPossibility(ints);
        System.out.println(b);
    }
}
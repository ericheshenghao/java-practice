package com.难度归档.简单.哈希表.错误的集合;


import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] ints = new int[2];
        int len = nums.length;
        int num = Arrays.stream(nums).sum()-len*(len+1)/2;
        for (int i = 0; i < nums.length; i++) {
            boolean add = set.add(nums[i]);
            if(!add){
                ints[0]= nums[i];
                ints[1]= nums[i]-num;
                break;
            }
        }
        return ints;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] errorNums = solution.findErrorNums(new int[]{1,2,2,4});

        for (int errorNum : errorNums) {
            System.out.println(errorNum);
        }
    }
}
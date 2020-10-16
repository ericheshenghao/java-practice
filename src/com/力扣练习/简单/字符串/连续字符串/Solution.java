package com.力扣练习.简单.字符串.连续字符串;

class Solution {
    public int maxPower(String s) {
         int left =0;
         int right =0;
         int res =1 ;
        char[] chars = s.toCharArray();
        while (right<s.length()-1){
             if(chars[++right]==chars[left])  ;
             else {
                 res = right-left>res? right-left:res;
                 left=right;
             }
         }

        return  right+1-left>res? right+1-left:res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int leetcode = solution.maxPower("abbcccddddeeeeedcba");

//        int leetcode = solution.maxPower("cc");
        System.out.println(leetcode);

    }
}
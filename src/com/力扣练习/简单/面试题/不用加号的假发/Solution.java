package com.力扣练习.简单.面试题.不用加号的假发;

class Solution {
    public int add(int a, int b) {
        System.out.println(a ^ b);
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.add(21,122);
    }
}
package com.难度归档.简单.数组.逐步求和得到正数的最小值;

class Solution {
    public int minStartValue(int[] nums) {
        int res=0;
        int other=0;
        for (int i = 0; i < nums.length; i++) {
             res+=nums[i];
             other = res<other? res:other;
        }
       return other==0?1:(-other)+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minStartValue(new int[]{-3,2,-3,4,2});
    }
}
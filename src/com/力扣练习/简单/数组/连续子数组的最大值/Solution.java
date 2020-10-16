package com.力扣练习.简单.数组.连续子数组的最大值;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];

        int[] dp = new int[nums.length];
        int maxans = nums[0];
        dp[0] = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            if(dp[i-1]<0) dp[i]= nums[i];
            else dp[i] = dp[i-1]+nums[i];
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
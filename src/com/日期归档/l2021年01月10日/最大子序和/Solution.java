package com.日期归档.l2021年01月10日.最大子序和;

/**
 * @author : heshenghao
 * @date : 20:11 2021/1/10
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxans= nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] =Math.max(nums[i],dp[i-1]+nums[i]);
            maxans = Math.max(dp[i],maxans);
        }
        return maxans;
    }
}
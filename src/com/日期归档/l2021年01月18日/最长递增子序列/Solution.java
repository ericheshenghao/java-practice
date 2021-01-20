package com.日期归档.l2021年01月18日.最长递增子序列;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 16:24 2021/1/18
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxans =1;
        for(int i=1;i<nums.length;i++){
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxans = Math.max(maxans,dp[i]);
        }

        return maxans;
    }
}
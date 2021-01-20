package com.日期归档.l2021年01月19日.最长递增子序列的个数;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 15:39 2021/1/19
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    // 第一次找到
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                        // 再次找到
                    } else if(dp[j]+1 == dp[i]) {
                        count[i] += count[j];
                    }



                }
            }

        }

         int longest = 0, ans = 0;
        for (int length: dp) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] == longest) {
                ans += count[i];
            }
        }
        return ans;

    }
}
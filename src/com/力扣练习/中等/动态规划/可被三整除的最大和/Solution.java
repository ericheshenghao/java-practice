package com.力扣练习.中等.动态规划.可被三整除的最大和;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        dp[0][0]=0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MAX_VALUE;

        for (int i = 0; i <=n; i++) {
            if(nums[i-1]%3 ==0){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][0] + nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][1] + nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][2] + nums[i-1]);
            }else if(nums[i-1]%3==1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2] + nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0] + nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1] + nums[i-1]);
            }else if(nums[i-1]%3==2){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1] + nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2] + nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][0] + nums[i-1]);
            }
        }
        return dp[n][0];
    }
}
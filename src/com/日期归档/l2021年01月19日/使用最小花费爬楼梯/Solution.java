package com.日期归档.l2021年01月19日.使用最小花费爬楼梯;

/**
 * @author : heshenghao
 * @date : 15:35 2021/1/19
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length+1;i++){
            if(i<cost.length){
                dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
            }else{
                dp[i] = Math.min(dp[i-1],dp[i-2]);
            }

        }
        return dp[cost.length];
    }
}
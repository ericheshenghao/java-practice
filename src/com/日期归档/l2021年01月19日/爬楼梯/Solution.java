package com.日期归档.l2021年01月19日.爬楼梯;

/**
 * @author : heshenghao
 * @date : 14:55 2021/1/19
 */
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] =1;
        dp[1] =2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
}
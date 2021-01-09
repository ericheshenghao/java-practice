package com.日期归档.l2021年01月09日.买卖股票的最佳时机III;

/**
 * @author : heshenghao
 * @date : 14:14 2021/1/9
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0 ) return 0;
        int[] dp = new int[5];
        dp[0] =0;
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return  dp[4];
    }
}
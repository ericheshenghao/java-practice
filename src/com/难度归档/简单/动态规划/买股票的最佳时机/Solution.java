package com.难度归档.简单.动态规划.买股票的最佳时机;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。

 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int p = prices[0];
        int res;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
             if(prices[i]<p) p=prices[i];
             res = prices[i]-p;
             max=res>max?res:max;
        }
        return max>0?max:0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
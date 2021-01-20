package com.日期归档.l2021年01月18日.最长递增子序列的个数;

import java.util.Map;

/**
 * @author : heshenghao
 * @date : 17:39 2021/1/18
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0]=1;
        int maxans=1;
        int maxlen =1;

        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            int temp=1;
            for (int j = 0; j < i; j++) {

                if(nums[i]>nums[j]){
                    dp[i] =Math.max(dp[i],dp[j]+1);
                    temp=maxans;
                    maxans = Math.max(dp[i],maxans);
                }

            }

            if(temp ==maxans){
                ++maxlen;
            }else{
                maxlen =1;
            }

        }
        return maxlen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numberOfLIS = solution.findNumberOfLIS(new int[]{2,2,2,2,2});
        System.out.println(numberOfLIS);
    }
}
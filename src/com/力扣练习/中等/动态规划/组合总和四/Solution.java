package com.力扣练习.中等.动态规划.组合总和四;

import java.util.Arrays;

class Solution {

    public int combinationSum4(int[] nums, int target) {

      int[][] dp = new int[target+1][nums.length+1];

        for (int i = 0; i <nums.length+ 1;i++) {
            dp[0][i]=1;
        }


        for (int i = 1; i < target+1; i++) {
            for (int j = 1; j < nums.length+1; j++) {

                for (int k = 0; k < j; k++) {
                    if(i-nums[k]>=0)  dp[i][j]+=dp[i-nums[k]][j];

                }

            }
        }
 
        return dp[target][nums.length];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);

    }
}
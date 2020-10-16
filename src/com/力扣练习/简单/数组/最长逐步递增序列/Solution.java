package com.力扣练习.简单.数组.最长逐步递增序列;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        int maxans = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
            maxans=Math.max(maxans,dp[i]);
        }
        
        
        return maxans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lengthOfLCIS = solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(lengthOfLCIS);
    }
}
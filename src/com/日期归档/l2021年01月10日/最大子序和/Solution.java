package com.日期归档.l2021年01月10日.最大子序和;

/**
 * @author : heshenghao
 * @date : 20:11 2021/1/10
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

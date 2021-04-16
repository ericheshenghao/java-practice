package com.日期归档.l2021年01月28日.寻找数组的中心索引;


/**
 * @author : heshenghao
 * @date : 16:42 2021/1/28
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0,leftSum=0,rightSum;
        for (int num : nums) {
            sum+=num;
        }
        for (int  i = 0;i<nums.length;i++) {
            rightSum = sum-leftSum-nums[i];

            if(leftSum==rightSum){
                return i;
            }
            leftSum +=nums[i];
        }
        return -1;
    }
}
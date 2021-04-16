package com.日期归档.l2021年01月27日.和为s的两个数字;

/**
 * @author : heshenghao
 * @date : 21:07 2021/1/27
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while((nums[left]+nums[right])!=target){
            if(nums[left]+nums[right]>target) --right;
            else ++left;
        }
        return new int[]{nums[left],nums[right]};
    }
}
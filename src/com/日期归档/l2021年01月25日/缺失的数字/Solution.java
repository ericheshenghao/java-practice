package com.日期归档.l2021年01月25日.缺失的数字;

/**
 * @author : heshenghao
 * @date : 21:40 2021/1/25
 */
class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
}
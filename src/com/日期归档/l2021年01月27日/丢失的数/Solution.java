package com.日期归档.l2021年01月27日.丢失的数;

/**
 * @author : heshenghao
 * @date : 22:02 2021/1/27
 */
class Solution {
    public int missingNumber(int[] nums) {
        int res =0;
        for(int num:nums){
            res^=num;
        }

        for(int i=0;i<nums.length+1;i++){
            res^=i;
        }
        return res;
    }
}
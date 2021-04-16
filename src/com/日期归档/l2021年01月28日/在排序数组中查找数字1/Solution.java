package com.日期归档.l2021年01月28日.在排序数组中查找数字1;

/**
 * @author : heshenghao
 * @date : 19:18 2021/1/28
 */
class Solution {
    public int search(int[] nums, int target) {
        int res=0;
        for(int num:nums){
            if(num==target){
                res++;
            }
            if(num>target){
                return res;
            }
        }

        return res;
    }
}
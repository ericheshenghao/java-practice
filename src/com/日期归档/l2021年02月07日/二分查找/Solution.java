package com.日期归档.l2021年02月07日.二分查找;

import java.lang.reflect.Array;

/**
 * @author : heshenghao
 * @date : 12:45 2021/2/10
 */
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0, nums.length);

    }

    int binarySearch(int[] nums , int target,int left,int right){
        int pivot = (left + right) / 2;
        System.out.println(pivot);
        if(nums[pivot] == target) return pivot;
        int res =0;
        if(nums[pivot] < target) res = binarySearch(nums,target,pivot,right);
        if(nums[pivot] > target) res = binarySearch(nums,target,left,pivot);
        return res;
    }
}
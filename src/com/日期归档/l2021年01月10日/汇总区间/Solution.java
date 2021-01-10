package com.日期归档.l2021年01月10日.汇总区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 19:41 2021/1/10
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int left =0;
        int right =1;
        if(nums.length==0) {
            return res;
        }
        if(nums.length==1) {
            res.add(nums[0]+"");
            return res;
        }

        while (right<nums.length){
            if(nums[right]==nums[right-1]+1){
                if(right==nums.length-1){
                    res.add(nums[left]+"->"+nums[right]);
                }
                right++;

            }else{
                if(nums[left]==nums[right-1]){
                    res.add(nums[left]+"");
                }else{
                    res.add(nums[left]+"->"+nums[right-1]);
                }

                if(right==nums.length-1){
                    res.add(""+nums[right]);
                }
                left=right;
                right++;
            }
        }
        return res;

    }
}
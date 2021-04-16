package com.日期归档.l2021年01月27日.只出现一次的数字;

/**
 * @author : heshenghao
 * @date : 21:52 2021/1/27
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res =0;
        for(int num:nums){
            res^=num;
        }
        return res;
    }
}
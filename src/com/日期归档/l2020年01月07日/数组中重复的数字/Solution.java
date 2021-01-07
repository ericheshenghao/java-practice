package com.日期归档.l2020年01月07日.数组中重复的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : heshenghao
 * @date : 14:12 2021/1/7
 */
class Solution {
    public int findRepeatNumber1(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if(map.containsKey(num)){
                return num;
            }else {
                map.put(num,true);
            }
        }
        return 0;
    }
    //其它解法
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i+1]==nums[i]&&i+1<nums.length  ){
                return nums[i];
            }
        }
        return 0;
    }
}
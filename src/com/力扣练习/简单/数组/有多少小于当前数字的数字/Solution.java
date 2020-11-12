package com.力扣练习.简单.数组.有多少小于当前数字的数字;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : heshenghao
 * @date : 9:20 2020/10/26
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = nums.clone();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) map.put(nums[i],i);
            else  map.put(nums[i],map.get(nums[i-1]));
        }

        for (int i =0;i<nums.length;i++){
            res[i] = map.get(res[i]);
        }
        return  res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});

    }
}
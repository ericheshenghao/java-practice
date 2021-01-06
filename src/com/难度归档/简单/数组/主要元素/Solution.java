package com.难度归档.简单.数组.主要元素;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length==1) return nums[0];

        for (int i = 0; i < nums.length; i++) {

            Integer integer = map.get(nums[i]);
            if(integer==null){
                map.put(nums[i],0);
            }else{
                map.replace(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])+1>nums.length/2){
                    return nums[i];
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.majorityElement(new int[]{1});
        System.out.println(i);
    }
}
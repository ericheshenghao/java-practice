package com.力扣练习.中等.回溯算法.全排列二;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        ba(nums,result,new ArrayList<Integer>(nums.length),0);

        return result;
    }

    private void ba(int[] nums, List<List<Integer>> result, List ints, int n) {
        if(n==nums.length){
            result.add(ints);
            return;
        }

        for (int i = n; i < nums.length; i++) {
            ints.add(nums[i]);
            List<Integer> store = ints;
            ba(nums,result,ints,n+1);
            ints=store;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});


        lists.forEach( System.out::println);
    }
}
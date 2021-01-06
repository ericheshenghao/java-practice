package com.难度归档.中等.贪心算法.用户分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> rev = new ArrayList<>();
        Arrays.sort(groupSizes);
        int start=0;
        for (int i = 0; i < groupSizes.length; i++) {
           // 3,3,3,3
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});

    }
}
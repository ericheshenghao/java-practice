package com.难度归档.中等.数组.数组嵌套;


import java.util.HashSet;
import java.util.Set;

/**
 * @author : heshenghao
 * @date : 11:20 2020/10/28
 */
class Solution {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=0;

        for (int i = 0; i < nums.length  ; i++) {
            int inner =i;
            int temp = 0;
            if(nums[i]==-1)continue;
            while (set.add(inner)){
                int t =inner;
                inner=nums[inner];
                nums[t]=-1;
                temp++;
            }
            set.clear();
            res = temp>res?temp:res;

        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.arrayNesting(new int[]{1, 0, 3, 4, 2});
        System.out.println(i);
    }
}
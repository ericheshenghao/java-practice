package com.日期归档.l2021年01月27日.错误的集合;

import java.util.HashSet;

/**
 * @author : heshenghao
 * @date : 12:39 2021/1/28
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int a=0;
        for (int num : nums) {
            if(!set.contains(num)){
                set.add(num);
            }else {
                a=num;
            }
        }

        for (int i = 0; i < nums.length+1; i++) {
            if(!set.contains(i)){
                return new int[]{a,i};
            }
        }

        return null;
    }
}
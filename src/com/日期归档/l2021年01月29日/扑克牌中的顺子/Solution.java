package com.日期归档.l2021年01月29日.扑克牌中的顺子;

import java.util.HashSet;

/**
 * @author : heshenghao
 * @date : 20:35 2021/1/29
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) return false;
            set.add(num);
            if(num==0) continue;
            if(num>max) max=num;
            if(num<min) min=num;
        }

        return  max-min<5;
    }
}
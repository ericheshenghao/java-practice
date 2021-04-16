package com.日期归档.l2021年02月07日.拿硬币;

/**
 * @author : heshenghao
 * @date : 15:43 2021/2/26
 */
class Solution {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int i : coins) {
            double time = Math.ceil(i / 2);
            System.out.println(time);
            ans += time;
        }
        return ans;
    }
}
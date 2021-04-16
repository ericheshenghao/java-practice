package com.日期归档.l2021年01月28日.只出现一次的数字2;

/**
 * @author : heshenghao
 * @date : 22:14 2021/1/27
 */
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.singleNumber(new int[]{1,1,6,1});
    }
}
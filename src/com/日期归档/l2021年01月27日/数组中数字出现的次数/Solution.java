package com.日期归档.l2021年01月27日.数组中数字出现的次数;

/**
 * @author : heshenghao
 * @date : 20:11 2021/1/27
 * [100,001,100,110]
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumbers(new int[]{4,1,4,6});
    }
}

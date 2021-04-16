package com.日期归档.l2021年01月28日.圆圈中最后剩下的数字;

/**
 * @author : heshenghao
 * @date : 16:59 2021/1/28
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
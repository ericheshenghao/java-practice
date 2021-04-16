package com.日期归档.l2021年01月26日.打印从1到最大的n位数;

/**
 * @author : heshenghao
 * @date : 18:31 2021/1/26
 */
class Solution {
    public int[] printNumbers(int n) {
        double pow = Math.pow(10, n);
        int[] res = new int[(int) pow];
        for (int i = 0; i < pow; i++) {
            res[i] = i;
        }
        return res;
    }
}
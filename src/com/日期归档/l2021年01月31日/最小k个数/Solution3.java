package com.日期归档.l2021年01月31日.最小k个数;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 22:14 2021/1/31
 */
class Solution3 {
    public int[] smallestK(int[] a, int k) {
        int right =a.length-1;
        int left = 0;
        int length = right - left + 1;
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }

        int[] result = new int[k];
        System.arraycopy(a, 0, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.smallestK(new int[]{1,3,5,7,2,4,6,8},4);
    }
}
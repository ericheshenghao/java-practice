package com.难度归档.中等.重新排序得到2的幂;

import java.util.Arrays;

class Solution {
    static public boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }

    // Returns the count of digits of N
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    static public   int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean b = reorderedPowerOf2((int) Math.pow(2,10));
        System.out.println(b);
    }
}


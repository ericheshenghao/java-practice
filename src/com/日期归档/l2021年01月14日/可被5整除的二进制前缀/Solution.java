package com.日期归档.l2021年01月14日.可被5整除的二进制前缀;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 15:00 2021/1/14
 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();

        int num = 0;
        for (int i = 0;i < A.length;i++) {
            num <<= 1;
            num += A[i];
            num %= 10;
            ans.add(num % 5 == 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1});
    }
}
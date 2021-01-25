package com.日期归档.l2021年01月25日.求和;

/**
 * @author : heshenghao
 * @date : 22:19 2021/1/25
 */
class Solution {
    public int sumNums(int n) {


        int pre = 1;
        int ans = 0;
        for (int i = 2; i < n+1; i++) {

            ans = pre + i;
            pre = ans;
        }
        return ans;
    }
}
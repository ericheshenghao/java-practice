package com.日期归档.l2021年01月17日.斐波那契数列;

/**
 * @author : heshenghao
 * @date : 0:21 2021/1/17
 */
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

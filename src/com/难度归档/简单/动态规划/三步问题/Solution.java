package com.难度归档.简单.动态规划.三步问题;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 */

class Solution {
    public int waysToStep(int n) {
        int p = 0, q = 0, r = 0,s=1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = s ;
            s = ((p+q)%1000000007+r)%1000000007;
        }

        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.waysToStep(4);
        System.out.println(i);

    }
}
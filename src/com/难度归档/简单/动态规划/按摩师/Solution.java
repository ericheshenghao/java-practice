package com.难度归档.简单.动态规划.按摩师;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int massage(int[] nums) {
        int first =0;
        int second =0;
        for (int num : nums) {
            int temp=second;
            second=Math.max(second,num+first);
            first=temp;
        }
        return second;
    }
}
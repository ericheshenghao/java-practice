package com.日期归档.l2021年01月20日.三个数的最大乘积;

import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 11:26 2021/1/20
 */
class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((u, v)->v-u);
        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
        }
        return queue.poll()*queue.poll()*queue.poll();
    }
}
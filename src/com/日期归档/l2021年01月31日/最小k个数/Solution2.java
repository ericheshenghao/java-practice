package com.日期归档.l2021年01月31日.最小k个数;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 22:14 2021/1/31
 */
class Solution2 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        Arrays.stream(arr).forEach(num -> heap.offer(num));
        int[] res = new int[k];
        int idx = 0;
        while (idx < k) res[idx++] = heap.poll();
        return res;

    }

}
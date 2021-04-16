package com.日期归档.l2021年02月07日.前K个高频元素;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 20:42 2021/2/7
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> counts =  new HashMap<>();
        for(int num:nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap =  new PriorityQueue<>(
                (a,b)-> counts.get(a).equals(counts.get(b)) ?
                        b.compareTo(a) : counts.get(a) - counts.get(b)
        );

        for(int num:counts.keySet()){
            heap.offer(num);
            if(heap.size()>k) heap.poll();
        }

        int[] res = new int[k];
        int i =k;
        while(!heap.isEmpty()){
            res[--i] = heap.poll();
        }
        return res;
    }
}
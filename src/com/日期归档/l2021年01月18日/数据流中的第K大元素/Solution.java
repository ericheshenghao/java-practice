package com.日期归档.l2021年01月18日.数据流中的第K大元素;

import com.日期归档.l2021年01月18日.删除二叉搜索树中的节点.Solution;

import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 22:02 2021/1/17
 */
class KthLargest {
    private PriorityQueue<Integer>  queue = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k =k;
        if(nums.length ==0) return;


        for (int i = 0; i < k && i< nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i <nums.length ; i++) {
            queue.offer(nums[i]);
            queue.poll();
        }

    }

    public int add(int val) {

        queue.offer(val);
        if(queue.size()>k){
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1,new int[]{});
        kthLargest.add(-3);
        kthLargest.add(-2);
    }
}

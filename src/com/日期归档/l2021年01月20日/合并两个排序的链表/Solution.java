package com.日期归档.l2021年01月20日.合并两个排序的链表;

import java.util.PriorityQueue;

/**
 * @author : heshenghao
 * @date : 21:25 2021/1/20
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        PriorityQueue<Integer> queue =   new PriorityQueue<>();
        while(l1!=null){
            queue.offer(l1.val);
            l1=l1.next;
        }

        while(l2!=null){
            queue.offer(l2.val);
            l2=l2.next;
        }
        ListNode head =   new ListNode(queue.poll());
        ListNode node = head;
        while(!queue.isEmpty()){
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return head;
    }

}
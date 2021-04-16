package com.日期归档.l2021年01月31日.反转链表;

/**
 * @author : heshenghao
 * @date : 22:13 2021/1/31
 */
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return newHead;
    }
}
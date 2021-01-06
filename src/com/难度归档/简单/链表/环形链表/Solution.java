package com.难度归档.简单.链表.环形链表;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    Boolean hasCycle =false;
    public boolean hasCycle(ListNode head) {

        cycle(head);
        return hasCycle;
    }

    private void cycle(ListNode head) {
        if(hasCycle) return;
        if(head.next.next==null) return;;
        ListNode next = head.next;
        ListNode next1 = head.next.next;

        if(next.val==next1.val){
            this.hasCycle=true;
            return ;
        }
        cycle(head);
    }
}
package com.日期归档.l2021年01月15日.环形链表;

/**
 * @author : heshenghao
 * @date : 11:19 2021/1/15
 */
  class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        while (fast!=null){
            if(fast.next==slow){
                return true;
            }
            slow=slow.next;
            fast= fast.next.next;
        }
        return false;
    }
}
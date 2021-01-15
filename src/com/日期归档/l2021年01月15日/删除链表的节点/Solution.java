package com.日期归档.l2021年01月15日.删除链表的节点;

/**
 * @author : heshenghao
 * @date : 11:05 2021/1/15
 */
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val ==val) return head.next;
        ListNode next =head;
        ListNode pre=head;
        while (next!=null){

            if(next.val==val){
                pre.next =next.next;
                break;
            } ;
            pre =next;
            next=next.next;
        }
        return head;
    }
}
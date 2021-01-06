package com.难度归档.中等.链表.删除链表的倒数第n个节点;



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rev =head;
        ListNode prev =null;
        ListNode curr =head;
        while (true){
           ListNode next = curr.next;
           if(next.next==null){
                 prev.next=next;
                 break;
             }
            prev=curr;
            curr=next;
        }
        return null;
    }
}
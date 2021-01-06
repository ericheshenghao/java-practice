package com.难度归档.简单.链表.删除排序链表中的重复元素;


 class ListNode {
   int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        delete(head);
        return head;
    }

    private void delete(ListNode head) {
        if(head==null) return;
        if(head.next!=null){
            if(head.val==head.next.val){
                if(head.next.next!=null){
                    head.next=head.next.next;
                }else {
                    head.next=null;
                }
                delete(head);
            }
            delete(head.next);
        }

    }
}
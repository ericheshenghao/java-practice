package com.力扣练习.中等.链表.两两较换链表中的节点;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode curr =head.next;
        ListNode res = head.next;
        while (curr!=null){
            ListNode pro = curr.next;
            curr.next=pre;

            if(pro!=null&& pro.next!=null){
                pre.next=pro.next;
                // 移动指针
                pre=pro;
                curr=pro.next;
            }else if(pro!=null && pro.next==null){
                pre.next=pro;
                return res;
            }
            else {

                pre.next =null;
                return res;
            }

        }
        return res;
    }
}
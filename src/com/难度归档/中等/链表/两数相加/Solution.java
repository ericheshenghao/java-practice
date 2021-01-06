package com.难度归档.中等.链表.两数相加;


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        getNumber(l1,l2,carry);
        return l1;
    }

    private void getNumber(ListNode l1, ListNode l2, int carry ) {
        if(l1==null && l2 ==null)  return;

        carry +=  (l1!=null?l1.val:0)+ (l2!=null?l2.val:0);

        l1.val = carry%10;
        carry/=10;

        if(l2.next==null && l1.next !=null) l2.next=new ListNode(0);
        if(l1.next==null && l2.next !=null) l1.next=new ListNode(0);
        if(l1.next==null && carry>0 ) {
            l1.next = new ListNode(0);
            l2.next = new ListNode(0);
        }
        getNumber(l1.next,l2.next,carry);
    }
}
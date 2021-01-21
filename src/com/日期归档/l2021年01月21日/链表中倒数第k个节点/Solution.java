package com.日期归档.l2021年01月21日.链表中倒数第k个节点;

/**
 * @author : heshenghao
 * @date : 20:03 2021/1/21
 */

  class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        int i =0;
        while (head.next!=null){
            head = head.next;
            i++;
            if(i>=k){
                res = res.next;
            }
        }
        return  res;
    }
}
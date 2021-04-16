package com.日期归档.l2021年02月03日.交换链表中的节点;

/**
 * @author : heshenghao
 * @date : 16:25 2021/2/3
 */


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    int tailNum = 0;
    int headNum = 0;
    ListNode headNode;

    public ListNode swapNodes(ListNode head, int k) {
        headNum++;
        if(headNum == k)  headNode = head; // 找到前交换节点
        if(head == null){
            return head;
        }
        swapNodes(head.next,k);
        tailNum++;
        if(tailNum == k){
            int temp = headNode.val;
            headNode.val = head.val;
            head.val = temp;
        }

        return head;
    }
}
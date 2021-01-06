package com.难度归档.简单.链表.删除中间节点;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public void deleteNode(ListNode node) {
        delete(node);
    }

    private void delete(ListNode node) {

        if(node.next==null) {
            return;
        }


        node.val=node.next.val;
        if(node.next.next==null){
            node.next=null;
            return;
        }
        delete(node.next);
    }
}
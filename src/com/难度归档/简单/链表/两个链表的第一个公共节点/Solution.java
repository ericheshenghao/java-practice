package com.难度归档.简单.链表.两个链表的第一个公共节点;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode  node1 =headA.next;
        ListNode node2 =headB.next;
        int time = 0;
        boolean flag =false;

        while (node1 != node2){
            node1 = node1.next;


            if(time==2){
                flag =true;
                break;
            }

            if(node1==null){
                time++;
                node1 = headB;
            }

            node2 = node2.next;
            if(node2==null){
                node2 = headA;
            }
        }

        if(flag) return null;
        return node1;
    }
}
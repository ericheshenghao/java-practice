package com.力扣练习.简单.链表.回文链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {

    public static void main(String[] args) {

    }
    int len;
    int len2;
    int time=0;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null ) return true;
        ListNode fastNode =head;
        ListNode slowNode =head;
        ArrayList<Integer> list = new ArrayList<>();

        while (slowNode!=null){
            slowNode=slowNode.next;
            len2++;
        }

        while (slowNode!=null){
            if(fastNode!=null&& fastNode.next!=null){
                fastNode = fastNode.next.next;
                list.add(slowNode.val);
                len= list.size();

            } else{
                Integer i = list.get(len - 1);
                if(len2%2!=0&& time!=1){
                    time+=1;
                    slowNode = slowNode.next;
                }
                len--;
                boolean equals = i.equals(slowNode.val);
                if(!equals) return false;
            }
             slowNode = slowNode.next;

        }


        return true;
    }
}
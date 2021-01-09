package com.日期归档.l2021年01月09日.从头到尾打印链表;

import java.util.*;

/**
 * @author : heshenghao
 * @date : 15:55 2021/1/9
 */

     class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        while (head!=null){
            result.addFirst(head.val);
            head=head.next;
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
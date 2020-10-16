package com.力扣练习.简单.链表.链表的中间节点;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class Solution {
    int n=0;
    public ListNode middleNode(ListNode head) {
        
        dfs(head);
        ListNode node =null;
        if(n%2==0){
              node = getNode(head, n / 2 + 1, 1);
        }else{
            node = getNode(head, (n-1)/ 2 + 1, 1);
        }

        return node;
    }
    private ListNode getNode(ListNode head,int n,int start){
        System.out.println(n);
        if(start==n) return head;
        ListNode node = getNode(head.next, n, start + 1);

        return node;
    }

    private void dfs(ListNode head) {
        if(head==null) return;
        n++;
        dfs(head.next);
    }


}
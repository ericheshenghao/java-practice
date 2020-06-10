package com.company.chapter20.单向链表;


/*
单链表中的节点
节点是单项链表中的基本的单元
每一个节点都有两个属性
  一个属性：是储存的属性
  另一个：是下一个节点的内存地址

 */
public class Node {

    Object element;
    Node next;

    public Node() {

    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }
}

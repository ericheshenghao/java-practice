package com.company.chapter20.单向链表;

public class Link {

    // 头节点
    Node header = null;

    private int size = 0;

    public int size() {
        return size;
    }

    // 添加元素的方法
    // 向末尾添加
    public void add(Object data) {
        // 让之前单链表的末尾节点指向新节点对象
        if (header == null) {
            // 即使头又是尾
            header = new Node(data, null);
        } else {
            //说明头不是空
            //头节点有了
            //找出末尾节点，让当前末尾节点的next是新节点
            Node currentLastNode = findLast(header);
            currentLastNode.next = new Node(data, null);
        }

        size++;
    }

    // 专门查找末尾节点的方法
    // 递归
    private Node findLast(Node node) {
        if (node.next == null) {
            // 如果一个节点的next是null 才会返回
            return node;
        }
        return findLast(node.next);
    }

    // 删除某个元素
    public void remove(Object o) {

    }

    // 修改某个数据
    public void modify(Object newobj) {

    }

    // 获取某个元素
    public int find(Object obj) {
        return 1;
    }
}

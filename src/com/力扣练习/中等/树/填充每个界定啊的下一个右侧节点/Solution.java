package com.力扣练习.中等.树.填充每个界定啊的下一个右侧节点;

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class Solution {
    public Node connect(Node root) {
        List<ArrayDeque<Node>> res =new ArrayList<>();
        bfs(root,0,res);

        res.forEach(System.out::println);
        return root;
    }

    private void bfs(Node root, int dept, List<ArrayDeque<Node>> res) {
        if(root==null) return;
        if( dept==res.size()){
            res.add(new ArrayDeque<>());
        }
        ArrayDeque<Node> nodes = res.get(dept);


        if(nodes.size()>0){
            Node pop = nodes.pollFirst();

            pop.next=root;
        }

        nodes.push(root);

        bfs(root.left,dept+1, res);
        bfs(root.right,dept+1, res);
    }
}
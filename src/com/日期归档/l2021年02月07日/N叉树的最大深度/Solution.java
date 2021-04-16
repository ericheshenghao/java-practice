package com.日期归档.l2021年02月07日.N叉树的最大深度;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author : heshenghao
 * @date : 20:25 2021/2/15
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public int maxDepth(Node root) {
        return dfs(root,0);
    }

    int dfs(Node root,int dept) {
        if(root.children ==null) return dept;
        Iterator<Node> iterator = root.children.iterator();
        while (iterator.hasNext()){

          dept = Math.max(dfs(iterator.next(),dept+1),dept);
        }
        return dept;
    }
}
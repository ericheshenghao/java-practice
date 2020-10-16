package com.力扣练习.简单.树.二叉搜索树的最近公共祖先;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    HashMap<Integer,TreeNode> path = new HashMap<Integer,TreeNode>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root,p,q);
            return null;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return ;


         dfs(root.left, p, q);
         dfs(root.right, p, q);

        if(root==p){
            System.out.println(p.val);
            p=root;
        }

        
    }
}
package com.力扣练习.中等.树.二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<Integer>();
        dfs(root,res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root==null) return;

        dfs(root.left,res);
        dfs(root.right,res);
        res.add(root.val);
    }
}
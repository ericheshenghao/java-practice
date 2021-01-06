package com.难度归档.简单.树.路径总和;

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    boolean hasPath;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root,sum);

        return hasPath;
    }

    private void dfs(TreeNode root, int sum) {
        if(root==null) {
          if(sum==0)   hasPath =true;
        }

        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);
    }
}
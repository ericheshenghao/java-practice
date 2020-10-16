package com.力扣练习.简单.树.二叉树的直径;

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int dfs = dfs(root, 0);
        return dfs;
    }

    private int dfs(TreeNode root, int dept) {
        if(root==null) return dept;

        int left = dfs(root.left, dept + 1);
        int right = dfs(root.right, dept + 1);


        if(dept==0){
            if(right>0) right=right-1;
            if(left>0) left=left-1;
            return left+right;
        }

        return right>left?right:left;
    }
}
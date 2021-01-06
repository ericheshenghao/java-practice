package com.难度归档.中等.树.二叉搜索树中的插入操作;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
            dfs(root,val);
            return root;
    }

    private void dfs(TreeNode root, int val) {
        if(root==null) return;
        dfs(root.left,val);
        if(root.left==null || root.right==null && root.val<val){
            System.out.println(root.val);
        }
        dfs(root.right,val);
    }
}
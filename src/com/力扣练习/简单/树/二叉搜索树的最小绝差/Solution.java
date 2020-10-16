package com.力扣练习.简单.树.二叉搜索树的最小绝差;

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {

    int temp;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root==null) return;


        dfs(root.left);

          res = Math.min(res, (root.val - temp));
        
        System.out.println(root.val);
        temp =root.val;
        dfs(root.right);
    }
}
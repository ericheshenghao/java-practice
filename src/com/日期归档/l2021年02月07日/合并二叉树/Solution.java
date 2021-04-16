package com.日期归档.l2021年02月07日.合并二叉树;

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

/**
 * @author : heshenghao
 * @date : 11:37 2021/2/14
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = root1;

        dfs(root1,root2);

        return res;
    }

    TreeNode dfs(TreeNode root1,TreeNode root2){
        if(root1==null && root2 ==null) return null;

        root1.left = dfs(root1.left,root2.left==null?null:root2.left);
        root1.right = dfs(root2.right,root2.right==null?null:root2.right);

        return root1;
    }
}
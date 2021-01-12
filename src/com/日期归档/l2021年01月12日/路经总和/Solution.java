package com.日期归档.l2021年01月12日.路经总和;

/**
 * @author : heshenghao
 * @date : 21:07 2021/1/12
 */

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        return   dfs(root,sum);
    }

    private boolean dfs(TreeNode root, int sum) {

        if(root==null) return false;

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        boolean left =  dfs(root.left,sum-root.val);

        boolean right =  dfs(root.right,sum-root.val);

        return left || right;
    }
}
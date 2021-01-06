package com.难度归档.简单.树.翻转二叉树;

/**
 * 输入
 *    4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出
 *    4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
    }

    private void invert(TreeNode node) {
        if(node==null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right=temp;


        invert(node.left);
        invert(node.right);
    }
}
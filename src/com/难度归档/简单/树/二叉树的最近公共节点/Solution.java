package com.难度归档.简单.树.二叉树的最近公共节点;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {

    char[] res1;
    char[] res2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,"",p,q);

        for (int i = 0; i < res1.length; i++) {
            if(res1[i]==res2[i]&&res1[i+1]==res2[i+1]){
                return new TreeNode(res1[i]);
            }
        }
        return null;
    }

    private void dfs(TreeNode root,String s, TreeNode p,TreeNode q) {
        if(root==null) {
            return;
        };

        if(root==p){
            res1 = (s + root.val).toCharArray();
        }

        if(root==q){
            res2 = (s + root.val).toCharArray();
        }

        dfs(root.left,s+root.val,p,q);
        dfs(root.right,s+root.val,p,q);
    }
}
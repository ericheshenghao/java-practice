package com.难度归档.中等.树.二叉树的层级遍历.广度解法;


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

       }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int curr = queue.size();
            for (int i = 1; i <= curr; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
           ret.add(level);
        }

        return  ret;
    }
}
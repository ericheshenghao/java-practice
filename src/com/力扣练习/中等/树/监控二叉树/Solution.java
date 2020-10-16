package com.力扣练习.中等.树.监控二叉树;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution {
    int ans=0;
    public int minCameraCover(TreeNode root) {
        if (lrd(root) == 0) ans++;
        return ans;
    }

    //0：未被覆盖(当前节点未被照到)
    //1：已被覆盖(摄像头已经照到这个节点)
    //2：需放置摄像头

    int lrd(TreeNode node) {
        if (node == null) return 1;

        int left = lrd(node.left);
        int right = lrd(node.right);
        System.out.println(left);
        System.out.println(right);
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        if(left == 1 && right == 1) return 0;

        return 1; // left+right>=3
    }
}
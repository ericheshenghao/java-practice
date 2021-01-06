package com.难度归档.中等.树.二叉树的中序遍历;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        inorder(root,arrayList);

        return arrayList;
    }

    private void inorder(TreeNode root,List<Integer> arrayList) {
        if(root==null) return;
        if(root.left!=null) {
            inorder(root.left,arrayList);
        }
        arrayList.add(root.val);
        if(root.right!=null) {
            inorder(root.right,arrayList);
        }
    }
}

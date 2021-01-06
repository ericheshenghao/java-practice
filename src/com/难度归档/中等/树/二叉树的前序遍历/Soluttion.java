package com.难度归档.中等.树.二叉树的前序遍历;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rev = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();

            if(pop!=null){
                rev.add(pop.val);
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }

        return  rev;
    }

}
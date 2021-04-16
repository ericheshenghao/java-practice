package com.日期归档.l2021年02月07日.二叉树的右视图;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


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
    HashMap<Integer,Integer> ans  =  new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans.values().stream().collect(Collectors.toList());
    }

    void dfs(TreeNode root, int dept){
        if(root == null) return;
        System.out.println(ans.values());
        if(!ans.containsKey(dept)){
            ans.put(dept,root.val);
        }
        if(root.right != null) dfs(root.right,dept++);
        if(root.left != null) dfs(root.left,dept++);

    }
}
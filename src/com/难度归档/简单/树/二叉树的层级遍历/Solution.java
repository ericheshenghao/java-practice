package com.难度归档.简单.树.二叉树的层级遍历;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>>  lists =  new ArrayList<>();
        leverOrder(root,lists,0);

        Collections.reverse(lists);

        return  lists;
    }
    // 广度优先搜索
    private void leverOrder(TreeNode root, List<List<Integer>> lists,int dept) {
        if(root==null) return;

        if( dept==lists.size())
        {
            lists.add(new ArrayList<>());
        }
        lists.get(dept).add(root.val);

        leverOrder(root.left,lists,dept+1);
        leverOrder(root.right,lists,dept+1);
    }


}

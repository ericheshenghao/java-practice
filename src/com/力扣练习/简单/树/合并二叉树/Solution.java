package com.力扣练习.简单.树.合并二叉树;


import sun.reflect.generics.tree.Tree;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        merge(t1,t1,t2,"");
        return t1;
    }

    private void merge(TreeNode root, TreeNode t1, TreeNode t2, String s) {
        if(t1==null && t2==null) return;
        if(t1!=null&& t2!=null ){
            t1.val+=t2.val;
        }



        if(t1==null && t2!=null){
            if(s.equals("left")){
                root.left=t2;
            }else if(s.equals("right")){
                root.right=t2;
            }
            return;
        }

        if(t1!=null && t2==null){
            return;
        }

        root =t1;
        merge(root,t1.left,t2.left,"left");
        merge(root,t1.right,t2.right,"right");
    }
}
package com.难度归档.中等.树.二叉树的之字形遍历;

import java.util.*;

  class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

public class Solution {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {

        ArrayList<ArrayList<Integer>> res=new ArrayList();
        if(root==null)
            return res;
        int level=0;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> item=new ArrayList<>();
            for(int i=0;i<size;++i){
                TreeNode node=queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                if((level&1)==0)
                    item.add(node.val);
                else
                    item.add(0,node.val);
            }
            res.add(item);
            ++level;
        }
        return res;
    }

}


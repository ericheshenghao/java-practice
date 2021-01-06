package com.难度归档.简单.树.二叉搜索树中的众数;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) {
         val = x;
     }
 }

class Solution {
   int val=-1,count=1,max=1;
 List<Integer> array= new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        if(root.left==null&&root.right==null) return new int[]{root.val};
        dfs(root );
        int[] ints = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            ints[i] = array.get(i);
        }
        return ints;
    }

    private void dfs(TreeNode root ) {
        if(root==null) return;
        dfs(root.left );
        System.out.println(root.val);
        if(val==root.val){
            count++;
            System.out.println(count);

            if(count==max){
                array.add(root.val);
            }

            if(count>max){
                max=count;
                Iterator<Integer> iterator = array.iterator();
                while (iterator.hasNext()){

                    Object item = iterator.next();
                    iterator.remove();
                }
                array.add(root.val);
            }

        }else{
            count=1;
            if(count>=max){
                array.add(root.val);
            }

        }
        val=root.val;
        dfs(root.right );
    }
}
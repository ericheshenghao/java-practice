package com.力扣练习.简单.栈.设计getMin功能的栈;

import java.util.*;

public class Solution {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    Stack<Integer> que = new Stack<>();

    public int[] getMinStack (int[][] op) {
        // write code here
        List<Integer> rev = new ArrayList<>();
        for(int[] o:op){
            if(o[0]==1) push(o[1]);
            if(o[0]==3)  rev.add(getMin());
            if(o[0]==2)  pop();
        }

        return  rev.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int getMin(){
        return minQueue.peek();
    }

    public void push(int val){
        minQueue.add(val);
        que.push(val);
    }

    public void top(){
        minQueue.peek();
    }


    public void pop(){
        int u = que.pop();
        minQueue.remove(u);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1,3},{1,2},{1,1},{3},{2},{3}};
        solution.getMinStack(ints);
    }

}
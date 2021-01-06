package com.难度归档.简单.栈.棒球比赛;

import java.util.Stack;

/**
 * @author : heshenghao
 * @date : 15:31 2020/10/21
 */
class Solution {
    public int calPoints(String[] ops) {



        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ;i<ops.length;i++){

            if(ops[i].equals("C")){
                stack.pop();
            }
            else if(ops[i].equals("D")){
                Integer peek = stack.peek();
                stack.push(2*peek);
            }
            else if(ops[i].equals("+")){
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.push(pop1);
                stack.push(pop);
                stack.push(pop+pop1);
            }
            else{

                stack.push( Integer.valueOf(ops[i]));
            }

        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return  res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.calPoints(new String[]{"123", "abc"});


    }
}
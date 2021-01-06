package com.难度归档.中等.栈.行星碰撞;

import java.util.Stack;

/**
 * @author : heshenghao
 * @date : 13:23 2020/10/21
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<asteroids.length;i++){
            Integer target =asteroids[i];
            if(stack.size()>0){
                Integer n = stack.peek();

                if(n< 0 && target<0){
                    stack.push(target);
                    continue;
                }
                if(target>0){
                    stack.push(target);
                    continue;
                }

                while(true){
                    if(n<0 && target<0){
                        stack.push(target);
                        break;
                    }
                    if( n<=Math.abs(target)){
                        Integer s = stack.pop();
                        if(s==Math.abs(target)) break;
                    }else break;

                    if(stack.size()==0){
                        stack.push(target);
                        break;
                    }

                    n=stack.peek();

                }



            }else{
                stack.push(target);
            }
        }

        int[] rev = new int[stack.size()];
        int i =stack.size()-1;
        while(stack.size()>0){
            rev[i--]=stack.pop();
        }
        return rev;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.asteroidCollision(new int[]{-2, -1, 1,2});
    }
}
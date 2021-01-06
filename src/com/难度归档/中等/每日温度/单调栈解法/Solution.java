package com.难度归档.中等.每日温度.单调栈解法;

import java.util.ArrayDeque;

class Solution {
    public static int[] dailyTemperatures(int[] T) {

        int[] ints = new int[T.length];

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {

            while (deque.size()!=0 && T[deque.peek()]<T[i]){

                int pop = deque.pop();
                 ints[pop] = i-pop;

            }
            deque.addFirst(i);
        }


        return ints;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(arr);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
package com.力扣练习.中等.每日温度;

class Solution {
    public static int[] dailyTemperatures(int[] T) {

        int[] ints = new int[T.length];
        for (int i = 0; i < T.length; i++) {

            for (int j = i; j < T.length; j++) {
                if(T[i]<T[j]) {

                    ints[i] = j-i;

                }
                System.out.println(i+":"+j);
            }
        }
        return ints;
    }

    public static void main(String[] args) {
       int[] arr = {89,62,70,58,47,47,46,76,100,70};
        int[] ints = dailyTemperatures(arr);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

}
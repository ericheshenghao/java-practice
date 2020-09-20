package com.力扣练习.中等.每日温度.kmp解法;


class Solution {
    public static int[] dailyTemperatures(int[] T) {
        int n =T.length;
        int[] ints = new int[n];
        for (int i = n-2; i > -1; i--) {
            int now=i+1; //i=6 now=7 T[6]=76 >T[7]=73 ints[now]=0
            while (T[now]<=T[i]){
                if(ints[now]!=0){
                    now +=ints[now];
                }else break;
            }
            if(T[now]>T[i]){
                ints[i] =now-i;
            }
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
package com.力扣练习.笔试.排序题.直接插入排序;

public class Solution {
    public int[] InsertSort(int[] a){
         int j;
        for (int p = 1; p < a.length ; p++) {
            int temp = a[p];
            for (j = p; j >0 && temp <a[j-1] ; j--) {
                a[j] = a[j-1];
            }
            a[j]=temp;
        }
        return a;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = solution.InsertSort(new int[]{3, 2,4,3});
        for (int anInt : a) {
            System.out.println(anInt);
        }
    }
}

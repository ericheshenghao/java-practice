package com.难度归档.笔试.排序题.直接选择排序;


public class Solution {

    public int[] SelectSort(int[] A){
        int min;
        int temp;
        for (int i = 0; i < A.length-1; i++) {
                min=i;
            for (int j = i+1; j <A.length; j++) {
                if(A[j]<A[min]) min=j;
            }
            if(min!=i){
                temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sort = solution.SelectSort(new int[]{2, 4, 3, 5, 1});
        for (int i : sort) {
            System.out.println(i);
        }
    }
}

package com.力扣练习.笔试.排序题.推排序;

public class Solution {
    private static int leftChild(int i){
        return 2* i+1;
    }

    private static void percDonw(int[] a,int hole,int n){
        int child;
        int temp;
        for (temp = a[hole];  leftChild(hole)<n ; hole=child) {
            child=leftChild(hole);
            if(child!=n-1 && a[child]<a[child+1]) child++;
            if (temp<a[child]) a[hole] =a[child];
            else break;
        }
        a[hole] =temp;
    }

    public static void heapsort(int[] a){
        for (int i =a.length/2-1;i>=0;i--){
            percDonw(a,i,a.length);
        }

        for (int i =a.length-1;i>0;i--){
            swapReferences(a,0,i);
            percDonw(a,0,i);
        }
    }

    private static void swapReferences(int[] a, int i, int i1) {

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.heapsort(new int[]{2,3,4,1,2,6});
    }


}

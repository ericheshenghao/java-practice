package com.难度归档.简单.数组.有序数组的平方;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] a) {
        for(int i=0;i<a.length;i++){
            a[i]*=a[i];
        }
        Arrays.sort(a);
        return a;
    }
}
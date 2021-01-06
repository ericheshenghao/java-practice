package com.难度归档.简单.堆.最小的k个数;

import java.util.Arrays;

class Solution {
   static public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
       int[] res =  new int[k];

       for (int i = 0; i < k; i++) {
           res[i] = arr[i];
       }

       return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        int k =2;
        int[] leastNumbers = getLeastNumbers(arr, 2);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }
    }
}
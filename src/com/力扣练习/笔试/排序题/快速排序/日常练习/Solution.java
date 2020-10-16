package com.力扣练习.笔试.排序题.快速排序.日常练习;


import java.util.List;

public class Solution {

    public static void quickSort(int[] arr,int low,int high) {
       if(low<high){
           int pivot = partition(arr,low,high);

           quickSort(arr,low,pivot-1);
           quickSort(arr,pivot+1,high);
       }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low<high){
            while (low<high&& arr[high] > pivot) high--;
            arr[high] = arr[low];
            while (low<high && arr[low]<pivot) low++;
            arr[low] =arr[high];
     }

        arr[low] = pivot;
        return low;
    }


    public static void main(String[] args) {
        com.力扣练习.笔试.排序题.快速排序.数组版本.Solution solution = new com.力扣练习.笔试.排序题.快速排序.数组版本.Solution();
        int[] arr = new int[]{2,3,4,5,1,8};
        solution.quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}


package com.难度归档.笔试.排序题.快速排序.数组版本;

public class Solution {

    public static void quickSort(int[] arr,int low,int high) {
             if(low<high){
                int pivot = partition(arr,low,high);
                 quickSort(arr, low, pivot - 1);
                 quickSort(arr, pivot + 1, high);
             }
    }

    private static int partition(int[] arr, int low, int high) {
       int pivot = arr[low];
        while (low<high){
            // 遇到小值 交换
            while (low<high && arr[high]>=pivot) --high;
            arr[low] =arr[high];
            // 遇到大值 较换
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] =arr[low];
        }
        arr[low] =pivot;
        return low;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,3,4,5,1,8};
        solution.quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}

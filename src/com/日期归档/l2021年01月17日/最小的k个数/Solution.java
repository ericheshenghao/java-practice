package com.日期归档.l2021年01月17日.最小的k个数;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 23:04 2021/1/16
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return qsort(arr,0,arr.length-1,k-1);
    }

    public int[] qsort(int[] arr,int low,int high,int k){
        int pivot = partition(arr, low, high);
        if(k==pivot) return Arrays.copyOf(arr, pivot+1 );
        return pivot > k? qsort(arr, low, pivot - 1, k): qsort(arr, pivot + 1, high, k);
    }

    public int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        while (low<high){
            while (low< high  && arr[high] >= pivot)  high--;

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot ) low++;
            arr[high] = arr[low];
        }
        arr[low] =pivot;
        return low;
    }
}
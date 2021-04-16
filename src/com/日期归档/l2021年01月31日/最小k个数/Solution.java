package com.日期归档.l2021年01月31日.最小k个数;


import java.util.Random;

/**
 * @author : heshenghao
 * @date : 22:14 2021/1/31
 */
class Solution {
    public int[] smallestK(int[] arr, int k) {
        qsort(arr,0,arr.length-1);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    void qsort(int[] arr,int low,int high){
        if(low <high){
            int pivot =  partition(arr,low,high);

            qsort(arr,low,pivot-1);
            qsort(arr,pivot+1,high);
        }
    }


    int partition(int[] arr,int low,int high){
        int pivot = arr[low+1];
        while(low < high){
            while( arr[high] > pivot){
                high--;
            }
            arr[low] = arr[high];
            while(arr[low] < pivot){
                low++;
            }
            arr[high] =arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
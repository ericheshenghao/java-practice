package com.日期归档.l2021年01月12日.数组中的第个最大元素;

/**
 * @author : heshenghao
 * @date : 20:02 2021/1/12
 */
class Solution {
//    public int findKthLargest(int[] nums, int k) {
//
//    }

    public  void qsort(int[] arr,int low,int high){
        if(low<high){
           int pivot = partition(arr,low,high);
            qsort(arr,low,pivot-1);
            qsort(arr,pivot+1,high);
        }
    }

    public int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        while(low<high){
            while(low<high && arr[high]>pivot){
                high--;
            }
            arr[low] =arr[high];
            while(low<high && arr[low]<pivot){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=pivot;
        return low;
    }




//    private static void qsort(int[] arr, int low, int high){
//        if (low < high){
//            int pivot=partition(arr, low, high);        //将数组分为两部分
//            qsort(arr, low, pivot-1);                   //递归排序左子数组
//            qsort(arr, pivot+1, high);                  //递归排序右子数组
//        }
//    }
//    private static int partition(int[] arr, int low, int high){
//        int pivot = arr[low];     //枢轴记录
//        while (low<high){
//            while (low<high && arr[high]>=pivot) {
//                --high;
//            }
//            arr[low]=arr[high];             //交换比枢轴小的记录到左端
//            while (low<high && arr[low]<=pivot) {
//                ++low;
//            }
//            arr[high] = arr[low];           //交换比枢轴大的记录到右端
//        }
//        //扫描完成，枢轴到位
//        arr[low] = pivot;
//        //返回的是枢轴的位置
//        return low;
//    }
//
        public static void main(String[] args) {

            int[] arr = {6, 1, 2, 7,9,3,4,5,10,8};
            Solution solution = new Solution();
            solution.qsort(arr,0,arr.length-1);
            for (int a : arr){
                System.out.println(a);
             }
        }
}

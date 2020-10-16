package com.力扣练习.笔试.排序题.二分插入排序;

import com.力扣练习.简单.链表.环形链表.Solution;

class BinaryInsertSort{
     public static int[] sort(int[] A)  {
         int len =A.length;
         int temp;
         int low, high, mid;
         for(int i =0 ;i<len;i++)  {
             temp = A[i];
             low = 0;
             high = i-1;
             while(low<=high){
              mid = (high + low)/2;
              if(temp<A[mid]){
                   high = mid -1;
              }
              else{
                      low = mid+1;
               }
             }
           for(int j = i-1;j>=high+1;j--){
                  A[j+1] =A[j];
           }
           A[high+1] =temp;
         }
         
         return A;
   }

    public static void main(String[] args) {
        BinaryInsertSort solution = new BinaryInsertSort();
        int[] sort = solution.sort(new int[]{2, 4, 3, 5, 1});

        for (int i : sort) {
            System.out.println(i);
        }
    }
}
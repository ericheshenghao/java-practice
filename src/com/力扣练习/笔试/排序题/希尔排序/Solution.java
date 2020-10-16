package com.力扣练习.笔试.排序题.希尔排序;

public class Solution {
      public void shellsort(int[] a){
          int j;
          for (int gap =a.length/2;gap>0;gap/=2){
              for (int i = gap; i < a.length ; i++) {
                  int tmp = a[i];
                  for (j=i;j>=gap &&tmp<a[j-gap];j-=gap) {
                      a[j] = a[j-gap];
                  }
                  a[j] =tmp;
              }
          }
      }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {2, 4, 3, 5, 1};
        solution.shellsort(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

}

package com.难度归档.中等.数组.最佳观光组合;

/**
 * @author : heshenghao
 * @date : 16:13 2020/10/21
 */
class Solution {
    int res =0;
    public int maxScoreSightseeingPair(int[] A) {
         trace(A,0,2,0);

         return res;
    }

    private void trace(int[] a,int start,int n,int temp) {
        if(n==1){
            temp+=start;
        }
        if(n==0){
            temp-=start;
            res = temp>res?temp:res;
        }
        for (int i =start; i < a.length; i++) {

            trace(a,i+1,n-1,temp+a[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
        System.out.println(i);
    }
}
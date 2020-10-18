package com.力扣练习.困难.回溯算法;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 12:52 2020/10/17
 */
class Solution {
    int res=0;
    public int totalNQueens(int n) {
        boolean[][] panel = new boolean[n][n];

        for(int i=0 ;i<n;i++)
            for(int j=0;j<n;j++)
                panel[i][j]=true;

        trace(n,panel,0,n);
        return res;
    }

    private void trace(int n,boolean[][] panel,int start,int dept) {
        if(dept==0){
            res++;
            return;
        }
        for (int i = start; i < n; i++) {
            if(i>n-dept) return;
            for (int j = 0; j < n; j++) {

                if(panel[i][j]){
                    boolean[][] temp = new boolean[n][n];
                    for(int m = 0;m < n;m++) {
                        temp[m] = Arrays.copyOf(panel[m], n);
                    }
                    int min = Math.min(i,j);
                    int max =Math.max(i,j);
                    int left =i-min;
                    int right =j-min;
                    // 右斜
                    int left1= i>j?i+min:i+max;
                    int right1=i>j?j-min:j-max;
                    for (int k = 0; k < n; k++) {
                        panel[i][k]=false;
                        if(left+k<n && right+k<n) panel[left+k][right+k]= false;
                        if(left1-k<n && right1+k<n && left1-k>=0 && right1+k>=0 ) panel[left1-k][right1+k]= false;
                        panel[k][j] =false;
                    }
                    trace(n,panel,i+1,dept-1);
                    panel=temp;
                }

            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.totalNQueens(5);
        System.out.println(i);
    }
}
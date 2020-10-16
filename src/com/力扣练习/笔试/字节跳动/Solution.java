package com.力扣练习.笔试.字节跳动;


public class Solution {

    public void getArea(int n,int[] array){

        int res =0;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                temp=(n-j-i)*getMin(i,n-j,array);
                if( temp>res) res =temp;
            }
        }
        System.out.println(res);
    }

    public int getMin(int start,int end,int[] array){
        int min = array[start];
        for(int i=start;i<end;i++){
            if(min>array[i]) min =array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getArea(7,new int[]{1,2,1,3,1,5,7});
    }
}
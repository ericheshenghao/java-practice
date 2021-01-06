package com.难度归档.笔试.分香蕉;

/**
 * @author : heshenghao
 * @date : 16:08 2020/11/16
 */
public class Solution {

    private static int m=0;

    public static void main(String[] args) {
        int m = part(1,1);
        System.out.println(m);
    }

    private static int part(int n, int k) {
        if((n%5==1)&&k<=5){
            if(k==5) return m;

            k++;

            return part((n-1)/5*4,k);
        }else {
            m++;
            return part(m,1);
        }

    }
}

package com.日期归档.l2021年02月01日.公平的糖果棒较换;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 21:04 2021/2/1
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int a =  Arrays.stream(A).sum();
        int b = Arrays.stream(B).sum();
        int diff =  Math.abs(a-b)/2;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(a>b){
                    if(A[i]-B[j]==diff){
                        return new int[]{A[i],B[j]};
                    }
                }else{
                    if(B[j]-A[i]==diff){
                        return new int[]{A[i],B[j]};
                    }

                }
            }
        }
        return null;

    }
}
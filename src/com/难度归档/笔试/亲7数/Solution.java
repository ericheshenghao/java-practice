package com.难度归档.笔试.亲7数;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 20:37 2020/12/20
 */
public class Solution {
    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    int result=0;
    public void reletive_7 (int[] digit) {
        int[] selected = new int[digit.length];
        Arrays.fill(selected,0);
        dfs(digit,selected,0,0);
        System.out.println(result);
    }

    private void dfs(int[] digit,int[] selected,int current,int dept) {
        if(dept==digit.length-1){
            if(current%7==0) {
                result+=1;
            }
            return;
        }
        for (int i = 0; i < digit.length; i++) {

            if(selected[i]==0){
                selected[i]=1;
                dfs(digit,selected, (int) (current+digit[i]*Math.pow(10,i)),dept+1);
                selected[i]=0;
            }
        }
    }
}
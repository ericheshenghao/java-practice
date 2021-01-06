package com.难度归档.简单.贪心算法.分发饼干;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sj=0;
        int gi=0;
        while (sj<g.length && gi<s.length){
            if(g[sj]<=s[gi]){
                sj+=1;
            }
            gi+=1;
        }
        return sj;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        solution.findContentChildren(g,s);
    }
}
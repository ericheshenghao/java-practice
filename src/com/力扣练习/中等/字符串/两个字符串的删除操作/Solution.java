package com.力扣练习.中等.字符串.两个字符串的删除操作;

/**
 * @author : heshenghao
 * @date : 13:33 2020/10/20
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 =word1.length()+1;
        int n2 = word2.length()+1;
        int[][] dp = new int[n1][n2];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for(int i =0;i<n2;i++){
            dp[0][i]=0;
        }
        for(int i =0;i<n1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<n1;i++){
            for(int j=1;j<n2;j++){

                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if( word1.substring(0,i-1).indexOf(chars1[i-1])==-1 && chars1[i-1]==chars2[j-1]) ++dp[i][j];
            }
        }
        return n1+n2-2-dp[n1-1][n2-1]*2;
    }
}
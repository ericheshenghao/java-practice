package com.难度归档.中等.贪心算法.令牌放置;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        int s1=0;
        int s2 = tokens.length-1;
        int time=0;
        if(tokens.length==1){
            return tokens[0]<p?1:0;
        }
        while (s1<=s2){
            if(tokens.length==0) break;
             p = p - tokens[s1];
            if(p>=0){
                time+=1;

            }
             if(p<0&&time==0) break;

            if (p<0&&time>0&&s1!=s2){
                p = p +tokens[s1]+tokens[s2] ;
                s2-=1;
                time-=1;
                continue;
            }
            s1+=1;

        }
        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] ints = {17,47,41,57,51};
        int[] ints = {100,200,300,400};
//         int p =31;
        int p =200;
        int i = solution.bagOfTokensScore(ints, p);
        System.out.println(i);

    }
}
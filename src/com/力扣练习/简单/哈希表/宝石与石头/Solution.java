package com.力扣练习.简单.哈希表.宝石与石头;

class Solution {
    public int numJewelsInStones(String J, String S) {
     int res= 0;
        for (int i =0;i<S.length();i++) {


            if(J.contains(S.substring(i,i+1))){
                res++;
            }
        }

        return res;
    }
}
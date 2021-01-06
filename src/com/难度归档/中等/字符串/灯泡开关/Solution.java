package com.难度归档.中等.字符串.灯泡开关;

class Solution {
    public int minFlips(String target) {

        int res =0;

        char[] chars = target.toCharArray();
        if(chars[0]=='1') res++;
        for (int i = 1; i < chars.length; i++) {
            if(i<chars.length-1 && chars[i]=='0' && chars[i+1]=='1'){

                res+=2;
            }
        }

        if(chars[0]=='0' && res>0) res--;
        if(chars[chars.length-1]=='0' && res>0) res++;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minFlips("010011101");
    }
}
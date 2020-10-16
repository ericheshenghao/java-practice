package com.力扣练习.简单.字符串.实现strStr;

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.equals("")) return 0;
        if(haystack.length() <needle.length() ) return -1;
        int ans = 0;

        for (int i=0;i<haystack.length();i++){
            if(haystack.length()-i<needle.length()) return -1;

            for ( int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    if(j==0) ans=i;
                }else  break;

                if(j==needle.length()-1) return ans;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("mississippi", "issip");
        System.out.println(i);
    }
}
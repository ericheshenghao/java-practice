package com.力扣练习.简单.字符串.字符串压缩;

import java.util.HashMap;

class Solution {
    public String compressString(String S) {
      int left=0;
      int right =0;
      StringBuffer res = new StringBuffer();
        char[] chars = S.toCharArray();

        while (right<chars.length-1){
            if(chars[++right]==chars[left]) ;
            else {
                res.append(chars[right-1]+""+(right-left));
                left=right;
            }
        }
        res.append(chars[right]+""+(right-left+1));
        return res.length()>S.length()?S:res.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String aabcccccaaa = solution.compressString("abbccd");
        System.out.println(aabcccccaaa);
    }
}
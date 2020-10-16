package com.力扣练习.简单.字符串.子序列;

import java.util.ArrayDeque;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s=="") return false;
        char[] chars = t.toCharArray();
        char[] sChar = s.toCharArray();
        ArrayDeque<Character> chars1 = new ArrayDeque<Character>(s.length());
        for (char c : sChar) {
            chars1.push(c);
        }
        for (char aChar : chars) {
            if(chars1.peekLast()==aChar){
                chars1.pollLast();
            }
            if(chars1.size()==0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean subsequence = solution.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }
}
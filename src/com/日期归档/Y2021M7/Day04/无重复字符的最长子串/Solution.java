package com.日期归档.Y2021M7.Day04.无重复字符的最长子串;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.日期归档.Y2021M7.Day04.无重复字符的最长子串
 * @Description:
 * @date : 2021/7/4 11:52
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("au");
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <=1){
            return s.length();
        }
        int res = 0;
        int left = 0;
        int right = 0;
        while(++right < s.length()) {
            String window = s.substring(left,right);
            res = Math.max(right - left,res);
            int i = window.indexOf(s.charAt(right));
            if(i != -1) left = left + i + 1;
        }
        return Math.max(right - left,res);
    }
}
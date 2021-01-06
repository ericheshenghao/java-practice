package com.难度归档.简单.数学.回文数;

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return  false;
        String s = String.valueOf(x);

        char[] chars = s.toCharArray();
        String reverse="";
        for (int i = s.length()-1;i>=0;i-- ) {
                 reverse += chars[i];  
        }
        return reverse.equals(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(10);
        System.out.println(palindrome);
    }
}
package com.难度归档.简单.数学.回文数.其他解法;

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left=0;
        int right =s.length()-1;
        char[] chars = s.toCharArray();

        while (left<right){
            if (chars[left]==chars[right]) ;
            else return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome(10);
        System.out.println(palindrome);
    }
}
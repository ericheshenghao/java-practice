package com.难度归档.简单.字符串.字符串相加;

class Solution {
    public String addStrings(String a, String b) {

        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(),b.length()), carry = 0;


        for (int i = 0; i < n; i++) {
            carry += i< a.length()? (a.charAt(a.length()-1-i)-'0'):0;
            carry += i< b.length()? (b.charAt(b.length()-1-i)-'0'):0;

            ans.append((char) carry%10);
            carry /=10;

        }

        return   ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addStrings("1222", "456");
        System.out.println(s);
    }
}
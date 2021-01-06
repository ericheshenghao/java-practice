package com.难度归档.简单.字符串.反转字符串;

class Solution {
    public void reverseString(char[] s) {
        String ss= "sdsdfs";

        for (int i = 0; i <= s.length/2; i++) {
            char temp = s[s.length-i-1];
            s[s.length-i-1] = s[i];
            s[i]=temp;
        }

       
    }
}
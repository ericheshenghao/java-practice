package com.力扣练习.简单.字符串.反转字符串;

import java.util.Arrays;
import java.util.stream.Collectors;

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
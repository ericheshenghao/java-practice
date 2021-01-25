package com.日期归档.l2021年01月24日.左旋转字符串;

import java.util.Arrays;

/**
 * @author : heshenghao
 * @date : 21:31 2021/1/24
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {


            builder.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {


            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseLeftWords("abcdefg",2);
    }
}
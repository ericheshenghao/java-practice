package com.力扣练习.简单.字符串.字符串的唯一字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) map.replace(chars[i],false);
            else   map.put(chars[i],true);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int leetcode = solution.firstUniqChar("loveleetcode");
        System.out.println(leetcode);
    }
}
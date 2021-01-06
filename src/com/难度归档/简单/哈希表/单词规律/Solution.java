package com.难度归档.简单.哈希表.单词规律;

import java.util.HashMap;
import java.util.Map;

class Solution {



    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.wordPattern("aba", "dog dog dog dog");
        System.out.println(b);

    }
}
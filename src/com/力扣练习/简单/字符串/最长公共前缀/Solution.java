package com.力扣练习.简单.字符串.最长公共前缀;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res= "";
        for (int i = 0; i <= strs[0].length(); i++) {
             String prefix = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                boolean b = strs[j].startsWith(prefix);
                if(!b) return res;
            }
            res = prefix;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }
}

package com.日期归档.l2021年02月07日.有效的字母异位词;

import java.util.HashSet;

/**
 * @author : heshenghao
 * @date : 0:01 2021/2/14
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int sum =0;
        for (char c:chars){
            set.add(c);
            sum+=(int) c;
        }
        for (char c:chars1){
            sum-=(int) c;
            if(set.add(c)) return false;
        }
        return sum==0;
    }
}
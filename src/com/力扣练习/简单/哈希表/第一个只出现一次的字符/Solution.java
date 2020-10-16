package com.力扣练习.简单.哈希表.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

    HashMap<Character,Boolean> map=  new HashMap<>();
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        char res =' ';
        for (char aChar : chars) {
            if(map.get(aChar)==null){
                map.put(aChar,true);
            }else {
                map.replace(aChar,false);
            }

        }
        for(char  achar:chars){
            if(map.get(achar)){
                return  achar;
            }
        }
        return  res;
    }
}
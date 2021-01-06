package com.难度归档.简单.字符串.山羊拉丁文;

import java.util.ArrayList;
import java.util.List;

class Solution {
 List<String>  array=   new ArrayList<String>();

    {
        array.add("A");
        array.add("E");
        array.add("I");
        array.add("O");
        array.add("U");
        array.add("a");
        array.add("e");
        array.add("i");
        array.add("o");
        array.add("u");
    }

    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        StringBuffer res = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if(array.contains(s[i].substring(0,1))){
                s[i] = s[i]+"ma";
            }else {
                String temp = s[i].substring(0,1);
               s[i]=s[i].substring(1);
                s[i]=s[i]+temp+"ma";;
            }
            s[i]+=buffer.append("a");
        }

        for (int i = 0; i < s.length; i++) {
            if(i!=s.length-1) res.append(s[i]+" ");
            else res.append(s[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String i_speak_goat_latin = solution.toGoatLatin("I speak Goat Latin");

    }
}
package com.力扣练习.简单.字符串.比较含退格的字符串;

import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean backspaceCompare(String s, String t) {

        String ss = backspace(s);
        String tt = backspace(t);
        return ss.equals(tt);
    }

    private String backspace(String s) {

        int i = s.indexOf("#");
        if(i!=-1){
            s = s.replace("\\S?#", "");
              s = backspace(s);
        }

        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.backspaceCompare("ab##", "c#d#");
        System.out.println(b);
    }
}
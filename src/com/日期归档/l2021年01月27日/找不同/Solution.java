package com.日期归档.l2021年01月27日.找不同;

/**
 * @author : heshenghao
 * @date : 21:54 2021/1/27
 */
class Solution {
    public char findTheDifference(String s, String t) {
        String sum = s + t;
        char[] chars = sum.toCharArray();
        char res = ' ';
        for(char ch:chars){
            res^=ch;
        }
        return (char) (res+32);
    }
}
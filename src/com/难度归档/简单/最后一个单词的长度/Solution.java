package com.难度归档.简单.最后一个单词的长度;

class Solution {
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
            

        if(s1.length==0){
            return 0;
        }

        return  s1[s1.length-1].length();
    }

    public static void main(String[] args) {
        int a = lengthOfLastWord("a");
        System.out.println(a);
    }
}
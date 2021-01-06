package com.难度归档.简单.字符串.检查单词是否为句中其他单词的前缀;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if(s[i].startsWith(searchWord)) return i;
        }

        return -1;
    }
}
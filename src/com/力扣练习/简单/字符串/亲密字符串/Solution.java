package com.力扣练习.简单.字符串.亲密字符串;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        if(A.equals(B)){
            int[] res = new int[26];
            for (char c : a) {
                if(++res[c - 'a'] == 2)
                    return true;
            }
            return false;
        }else{
            int[] temp = new int[a.length];
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if(a[i] != b[i]){
                    temp[index++] = i;
                }
            }
            if(index == 2){
                return a[temp[0]] == b[temp[1]] && b[temp[0]] == a[temp[1]];
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buddyStrings("abbb","abbb");
    }
}
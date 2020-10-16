package com.力扣练习.中等.字符串.检查提换后的词是否有效;

class Solution {
    public boolean isValid(String s) {

        while (s.contains("abc")){
            s = s.replace("abc","");
        }

        return  s.equals("abc") || s.equals("");
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean aabcbc = solution.isValid("cababc");
        System.out.println(aabcbc);
    }
}
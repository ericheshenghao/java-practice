package com.力扣练习.简单.字符串.比较含退格的字符串.栈解法;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.backspaceCompare("ab##", "c#d#");
        System.out.println(b);
    }
}

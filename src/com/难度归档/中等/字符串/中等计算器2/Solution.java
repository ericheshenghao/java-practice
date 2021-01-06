package com.难度归档.中等.字符串.中等计算器2;




import java.util.LinkedList;

import java.util.Stack;

class Solution {
    public int calculate(LinkedList<Character> s) {
        Stack<Integer> stk = new Stack<>();

        // 记录结果
        int num = 0;
        char sign='+';
        while (s.size()!=0){
            char c = s.pop();
            if(Character.isDigit(c)) num = 10*num + (c-'0');
            if(c=='(') num = calculate(s);

            // 如果不是数字，就是遇到了下一个字符, i==s.length() -1 比较关键
            if((!Character.isDigit(c) && c != ' ') || s.size()==0){
                int pre;
                switch (sign){
                    case '+':
                        stk.push(num); break;
                    case '-':
                        stk.push(-num); break;
                    case '*':
                        pre = stk.pop();
                        stk.push(pre*num); break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre/num); break;
                }
                // 更新符号，数字清零
                sign =c;
                num=0;
            }

            if(c==')') break;
        }

        // 将栈中所有结果求和
        int res =0 ;
        while (!stk.isEmpty()){
            res+=stk.pop();
        }
        return  res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList<Character> characters = new LinkedList<>();
        String s = "3+2*2";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            characters.add(aChar);
        }

        int calculate = solution.calculate( characters);
        System.out.println(calculate);
    }

}

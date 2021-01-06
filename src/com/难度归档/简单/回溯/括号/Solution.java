package com.难度归档.简单.回溯.括号;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        String subset = "";

        ArrayList<String> result = new ArrayList<>();
        Dfs(n,subset,result,0,0);

        return result;
    }

    private void Dfs(int n, String s, ArrayList<String> result, int left, int right) {
        if(left==n && right ==n){
            result.add(s);
            return;
        }

        if(left<right){
            return;
        }

        // 左括号不足，添加左括号进入下一层
        if(n > left)  Dfs(n,s+"(",result,left+1,right);

        // 右括号不足，添加右括号进入下一层
        if(n > right)    Dfs(n,s+")",result,left,right+1);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        strings.forEach(System.out::println);
    }
}
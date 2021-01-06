package com.难度归档.中等.字符串.括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result =  new ArrayList<>();
        dfs(n,result,"",0,0);
        return result;
    }

    private void dfs(int n, List<String> result, String s,int left,int right) {
        if(left==n && right==n){
         result.add(s);
         return;
        }

        if(right>left) return;

        if(n>left) dfs(n, result, s+"(",left+1,right);
        if(n>right) dfs(n, result, s+")",left,right+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        strings.forEach(System.out::println);
    }
}

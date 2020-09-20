package com.力扣练习.简单.回溯.无重复字符串的排序组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 */
class Solution {
    public String[] permutation(String string) {
        ArrayList<String> result = new ArrayList<>();
        dfs("",string,result,string.length());
        return   result.toArray(new String[0]);
    }

    public void dfs(String s, String origin, ArrayList<String> result, int num) {
        if(num==0){
            result.add(s);
            return;
        }

        for (int i = 0; i <origin.length(); i++) {
            String store = s;
            s+=origin.substring(i,i+1);
            String replace = origin.replace(origin.substring(i,i+1), "");
            dfs(s,replace,result,num-1);
            s = store;
        }
    }

    public static void main(String[] args) {
        String s = "qwe";
        Solution solution = new Solution();
        String[] permutation = solution.permutation(s);

        for (String ss:permutation
             ) {

           System.out.println(ss);
        }
    }
}
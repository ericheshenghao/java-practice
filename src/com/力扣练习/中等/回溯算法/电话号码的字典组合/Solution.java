package com.力扣练习.中等.回溯算法.电话号码的字典组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    static  final HashMap<String,String[]> hashMap = new HashMap<>();
    static {
     hashMap.put("2", new String[]{"a", "b","c"});
        hashMap.put("3", new String[]{"d", "e","f"});
        hashMap.put("4", new String[]{"g", "h","i"});
        hashMap.put("5", new String[]{"j", "k","l"});
        hashMap.put("6", new String[]{"m", "n","o"});
        hashMap.put("7", new String[]{"p", "q","r","s"});
        hashMap.put("8", new String[]{"t", "u","v"});
        hashMap.put("9", new String[]{"w", "x","y","z"});
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        dfs(digits,result,digits.length(),0,"");
        return result;
    }

    private void dfs(String digits, ArrayList<String> result, int num, int start,String s) {
        if (digits.length()==0) {
            return;
        }
        if(num==0){
            result.add(s);
            return;
        }


        for (int i = start; i < digits.length(); i++) {
            String[] strings = hashMap.get(digits.substring(i, i + 1));
            for (int j = 0; j < strings.length; j++) {
                dfs(digits,result,num-1,i+1,s+strings[j]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
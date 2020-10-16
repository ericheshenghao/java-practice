package com.力扣练习.中等.回溯算法.字符串的排列;



import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] permutation(String s) {
        List<String> rev = new ArrayList<>();
        trace(s,"",rev);
        return  rev.toArray(new String[rev.size()]);
    }
    public void trace(String s,String temp,List<String> rev){
        if(s.length()==0) rev.add(temp);
        char[] chars = s.toCharArray();

        for(int i=1;i<=s.length();i++){
            String str  = String.valueOf(chars[i-1]);
            String t = s.substring(0,i-1);

            if(t.contains(str)) continue;
            trace(t+s.substring(i),temp+str,rev);
        }
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Solution solution = new Solution();
        solution.permutation("xbjjlvjb");
        System.out.println(l -System.currentTimeMillis());
    }
}
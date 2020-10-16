package com.力扣练习.中等.字符串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] chars = pattern.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String temp="";
        for (char aChar : chars) {
            // 大写
            if(aChar<=90){
                list.add(temp);
                temp = ""+aChar;
            }else temp+=aChar;

        }
        list.add(temp);
        list.remove(0);
        ArrayList<Boolean> rev = new ArrayList<>();

        boolean queryFail =false;
        for (String query : queries) {
            queryFail =false;
            for (String s : list) {
                String t = query;
                query = query.replace(s,"");
                 if(t.equals(query)) queryFail =true;
            }
            if(queryFail) rev.add(false);
            else rev.add(true);

        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Boolean> fb = solution.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB");
        System.out.println(fb);
    }
}
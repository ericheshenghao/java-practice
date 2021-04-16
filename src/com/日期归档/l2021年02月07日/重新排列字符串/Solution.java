package com.日期归档.l2021年02月07日.重新排列字符串;

/**
 * @author : heshenghao
 * @date : 16:12 2021/2/26
 */
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars =  s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(indices[i]!=-1){
                char temp =  chars[indices[i]];
                chars[indices[i]] = chars[i];
                chars[i] = temp;
                indices[indices[i]] = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }
}
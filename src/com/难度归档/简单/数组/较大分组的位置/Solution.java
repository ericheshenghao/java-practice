package com.难度归档.简单.数组.较大分组的位置;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 20:31 2021/1/5
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int left = 0;
        int right =0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[left]==chars[right]){
                right++;
            }else{
                if(right-left>=3){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    lists.add(list);
                }
            }
        }

        return lists;
    }
}
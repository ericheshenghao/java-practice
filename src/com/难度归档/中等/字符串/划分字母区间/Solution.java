package com.难度归档.中等.字符串.划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 11:05 2020/10/22
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            last[chars[i]-'a'] =i;
        }

        ArrayList<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, last[chars[i] - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }

        return  partition;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }
}
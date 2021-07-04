package com.日期归档.Y2021M7.Day03.根据字符串出现频率排序;

import java.util.PriorityQueue;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.日期归档.I2021年07月03日.根据字符串出现频率排序
 * @Description:
 * @date : 2021/7/3 23:18
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println('a'+'a');
        System.out.println('A'+'A');
        String tree = solution.frequencySort("tree");
        System.out.println(tree);
    }

    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c:s.toCharArray()) {
            letters[c]++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> letters[o1]-letters[o2]);

        for (int i = 0; i < letters.length; i++) {
            if(letters[i] != 0){
                queue.offer((char) i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            char c = queue.poll();
            while (letters[c]-- > 0){
                res.append(c);
            }
        }
        return res.toString();
    }
}
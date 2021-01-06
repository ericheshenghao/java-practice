package com.难度归档.中等.字符串.根据字符串出现的频率排序;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) letters[c]++;

        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String tree = solution.frequencySort("Aabb");
        System.out.println(tree);

    }
}
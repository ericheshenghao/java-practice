package com.日期归档.l2021年02月07日.前K个高频单词;

import java.util.*;

/**
 * @author : heshenghao
 * @date : 19:40 2021/2/7
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},3);
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;

    }
}
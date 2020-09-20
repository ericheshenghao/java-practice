package com.力扣练习.中等.组合总和II.递归回宿;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<int[]>  freq = new ArrayList<int[]>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static List<Integer> sequence = new ArrayList<Integer>();

    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }
    // 8
    public static void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{4,1,1,4,4,4,4,2,3,5};


        int target = 10;
        List<List<Integer>> lists = combinationSum2(candidates, target);

        System.out.println(lists);
    }
}


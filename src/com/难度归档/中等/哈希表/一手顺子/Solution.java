package com.难度归档.中等.哈希表.一手顺子;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Arrays.sort(hand);
        List<Integer> collect = Arrays.stream(hand).boxed().collect(Collectors.toList());
//        int[] ints = collect.stream().mapToInt(Integer::valueOf).toArray();
        while (collect.size()>0){
          Integer first =   collect.remove(0);
            for (int i = 1; i < W; i++) {
                boolean remove = collect.remove(Integer.valueOf(first + i));
                if(!remove) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean nStraightHand = solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
        System.out.println(nStraightHand);
    }
}
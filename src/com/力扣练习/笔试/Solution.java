package com.力扣练习.笔试;

import java.util.Arrays;

public class Solution {

    static public int minMoves (int[] nums) {
        // write code here
        double reduce = new Integer(Arrays.stream(nums).reduce(0, Integer::sum)).doubleValue();

        return new Double(Math.ceil(reduce/nums.length)).intValue();
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 4};
        int i = minMoves(ints);
        System.out.println(i);
    }
}

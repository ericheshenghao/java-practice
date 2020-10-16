package com.力扣练习.中等.贪心算法.拼车;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ints = new int[1000];

        for (int[] trip : trips) {
            for (int i = trip[1]; i <trip[2] ; i++) {
                ints[i]+=trip[0];
            }
        }

        for (int anInt : ints) {
            if(anInt>capacity) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        boolean b = solution.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);

    }
}
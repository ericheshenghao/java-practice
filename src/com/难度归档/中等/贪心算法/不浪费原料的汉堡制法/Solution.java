package com.难度归档.中等.贪心算法.不浪费原料的汉堡制法;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < cheeseSlices+1 / 2; i++) {
            int jumbo = i;
            int small = cheeseSlices - i;
            if ((small * 2 + jumbo * 4) == tomatoSlices && jumbo + small == cheeseSlices) {
                list.add(jumbo);
                list.add(small);

            }
        }

    return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.numOfBurgers(9331810,2861909);
    }
}
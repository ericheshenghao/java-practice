package com.难度归档.中等.贪心算法.救生艇;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int rev=0;
        int end =0;
        for(int i = n - 1; i >= end; i--){
            if(people[i]+people[end]<=limit) end++;
            rev++;
        }
        return rev;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numRescueBoats(new int[]{3, 2,3,2,2}, 6);
        int j = solution.numRescueBoats(new int[]{5,1,4,2}, 6);
        int k = solution.numRescueBoats(new int[]{3, 5,3,4}, 5);
        // 3  2 4
        System.out.println(i+""+j+k);
    }
}
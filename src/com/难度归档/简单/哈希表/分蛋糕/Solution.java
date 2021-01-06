package com.难度归档.简单.哈希表.分蛋糕;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(candies[i]))  map.put(candies[i],1);
            if(map.size()>n/2) return n/2;
        }


        int size =  map.size();

        return size;
    }
}
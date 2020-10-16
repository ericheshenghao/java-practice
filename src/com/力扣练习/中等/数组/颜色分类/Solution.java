package com.力扣练习.中等.数组.颜色分类;

import java.util.HashMap;
import java.util.Set;

class Solution {
    public void sortColors(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) map.replace(num,map.get(num)+1);
            else map.put(num,1);
        };

        Set<Integer> integers = map.keySet();

        int j=0;
        int li = 0;
        for (int i : integers) {
            li += map.get(i);
            for (;j < li ; j++) {
                nums[j] = i;
            }
        }

    }
}
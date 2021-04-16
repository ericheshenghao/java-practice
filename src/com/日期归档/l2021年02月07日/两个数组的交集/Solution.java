package com.日期归档.l2021年02月07日.两个数组的交集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 22:58 2021/2/13
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums1){
            set.add(n);
        }

        List<Integer> ans = new ArrayList<>();
        for (int n:nums2){
            if(set.contains(n)){
                set.remove(n);
               ans.add(n);
           }
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
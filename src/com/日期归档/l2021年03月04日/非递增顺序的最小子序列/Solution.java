package com.日期归档.l2021年03月04日.非递增顺序的最小子序列;

/**
 * @author : heshenghao
 * @date : 13:48 2021/3/4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 3 4 8 9 10
 **/
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length;
        int condition = 0;

        for(int i = 0;i < len;i++){
            sum += nums[i];
        }

        for(int i = len - 1; i >= 0; i--){
            if(2 * condition <= sum ){
                ans.add(nums[i]);
                condition += nums[i];
            }else return ans;
        }

        return ans;
    }
}
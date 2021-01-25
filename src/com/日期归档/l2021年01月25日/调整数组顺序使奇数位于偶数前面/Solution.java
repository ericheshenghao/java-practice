package com.日期归档.l2021年01月25日.调整数组顺序使奇数位于偶数前面;

/**
 * @author : heshenghao
 * @date : 21:58 2021/1/25
 */
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left =0;
        int right = n-1;
        for (int i = 0; i < n; i++) {
            if(nums[i]%2==1){
                res[left++] = nums[i];
            }else{
                res[right--] = nums[i];
            }
        }
        return res;
    }
}
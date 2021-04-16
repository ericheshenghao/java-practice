package com.日期归档.l2021年01月27日.寻找重复数;

/**
 * @author : heshenghao
 * @date : 12:37 2021/1/28
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

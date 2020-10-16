package com.力扣练习.简单.数组.主要元素.投票解法;

class Solution {
    public int majorityElement(int[] nums) {
        int total = 1;
        int people= nums[0];
        for(int i = 1;i<nums.length;i++){
            if(people!=nums[i]){
                total--;
            }else{
                total++;
            }
            if(total<0){
                people = nums[i];
                total = 1;
            }
        }
        return total>0?people:-1;
    }

    public static void main(String[] args) {

          Solution solution = new Solution();
        int i = solution.majorityElement(new int[]{1,2,5,9,5,9,5,5,5});
        System.out.println(i);
    }
}
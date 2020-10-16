package com.力扣练习.中等.数组.最接近的三数之和;

class Solution {
    int res=Integer.MAX_VALUE;
    int rev;
    public int threeSumClosest(int[] nums, int target) {

        trace(nums,target,0,0,0);
        return rev;
    }

    private void trace(int[] nums, int target,int sum,int start,int selected) {
        if(selected==3){
            int temp = res;
            res= Math.min(Math.abs(sum-target),res);
            if(temp==res) rev=rev;
            else rev=sum;

            return;
        }

        if(start>nums.length-1) return;

        for (int i = start; i < nums.length; i++) {
            trace(nums,target,sum+nums[i],i+1,selected+1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int i = solution.threeSumClosest(new int[]{0,0,0}, 1);
        // 2
        int i = solution.threeSumClosest(new int[]{0,2,1,-3}, 1);
        System.out.println(i);
    }
}
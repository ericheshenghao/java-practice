package com.日期归档.l2021年01月13日.旋转数组的最小数字;

/**
 * @author : heshenghao
 * @date : 20:05 2021/1/13
 */
class Solution {
    public int minArray(int[] numbers) {
        if(numbers[numbers.length-1] > numbers[0]){
            return  numbers[0];
        }

        int left=0;
        int right=0;
        while (right<numbers.length-1&& (numbers[left]==numbers[right]||numbers[right]>numbers[left])   ){
            right++;
        }
        return numbers[right];
    }
}
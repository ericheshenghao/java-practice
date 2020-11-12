package com.力扣练习.简单.位运算;

/**
 * @author : heshenghao
 * @date : 8:53 2020/10/20
 */
class Solution {
    public int add(int a, int b) {
        while((a & b) != 0){
            int temp =a;
            a = a ^ b;
            b= (temp & b) << 1;

        }
        return a | b;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int add = solution.add(22, 54);
        System.out.println(add);
    }
}
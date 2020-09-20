package com.力扣练习.简单.排序.去掉最低工资和最高工资的平均值;

import java.util.Arrays;

public  class Solution {
    public double average(int[] salary) {

        Arrays.sort(salary);

        double max = salary[salary.length-1];
        double min = salary[0];


        double res = 0;
        for (int i = 0; i < salary.length; i++) {
            res+=salary[i];
        }


        return (res - max - min)/(salary.length-2);
    }


    public static void main(String[] args) {
        int[] salarys = new int[]{48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        Solution solution = new Solution();
        double average = solution.average(salarys);
        System.out.println(average);
    }
}
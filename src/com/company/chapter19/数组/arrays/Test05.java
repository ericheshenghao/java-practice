package com.company.chapter19.数组.arrays;

import java.util.Arrays;

/*
工具类
 */
public class Test05 {
    public static void main(String[] args) {
//        java.util.Arrays
        int[] arr = {3, 6, 5, 12, 1, 1, 1, 2, 32, 5, 5};
        Arrays.sort(arr);
        // 二分法查找
        int index = Arrays.binarySearch(arr, 32);
        System.out.println(index);
    }

}

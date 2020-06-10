package com.company.chapter19.数组.arrays;

import java.util.Arrays;

/*

 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 56, 67, 1};
        Arrays.sort(arr);
        // 输出
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

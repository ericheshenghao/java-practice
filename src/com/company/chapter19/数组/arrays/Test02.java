package com.company.chapter19.数组.arrays;

/*
冒泡排序
 */
public class Test02 {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 7, 6, 8};
        int[] arr = {9, 8, 10, 7, 6, 0, 11};
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j];
                    int b = arr[j + 1];
                    arr[j + 1] = a;
                    arr[j] = b;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //经过冒泡跑排序的算法对以上数组的元素进行排序
        // 核心就是左右对比
        // 2 7 6 8 3
        // 2 7 6 8 3
        // 2 6 7 8 3
        // 2 6 7 8 3
        // 2 6 7 3 8  第一次冒泡 冒出了最大的气泡 8
    }
}

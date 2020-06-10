package com.company.chapter19.数组.arrays;
/*
选择排序：
    每一次从这堆参与比较的数据中找出最小值
    拿着这个最小值和最前面的元素交换位置
    每次一的交换位置都是有意义的

 */

public class Test03 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 2, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int a = arr[i];
                    int b = arr[j];
                    arr[j] = a;
                    arr[i] = b;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

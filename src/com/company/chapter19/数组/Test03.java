package com.company.chapter19.数组;

public class Test03 {
    // (String[] args 数组
    public static void main(String[] args) {

        //调用方法时传一个数组
        int[] x = {1, 2, 3, 4};
        printArray(x);

        String[] y = {"1", "2", "3"};
        printArray(y);


    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

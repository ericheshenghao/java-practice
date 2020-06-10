package com.company.chapter19.数组;

/*
d当一个方法的参数是一个数组的时候，我们还可以采用这种方式
 */
public class Test04 {
    public static void main(String[] args) {

        // 初始化一个一维数组
        int[] a = {1, 2, 3};
        printArray(a);
        // 动态初始化
        int[] a2 = new int[4];

        printArray(new int[3]);

        // 如果直接传递一个静态数组的化，语法必须是这样写
        printArray(new int[]{4, 5, 6});

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

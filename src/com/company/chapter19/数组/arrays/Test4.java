package com.company.chapter19.数组.arrays;

/*
  元素查找
    一个一个找
    二分法
 */
public class Test4 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 56, 87, 8};
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]==87){
//                System.out.println(i);
//                return;
//            }
//        }
        //最好封装一个方法，传参数列表，以及被查找的元素。返回被查找的元素的下标
//        int index = arraySearch(arr,87);
        int[] arr1 = {11, 22, 33, 55, 66, 87};
//        arr1[333] = 87;
//        int index = arraySearch(arr1,87);
//        System.out.println(index ==-1?"不存在":"存在"+index);
        int index1 = binarySerch(arr1, 87);
        System.out.println(index1 == -1 ? "不存在" : "存在" + index1);

    }

    private static int binarySerch(int[] arr1, int i) {
        int begin = 0;
        int end = arr1.length - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (arr1[mid] == i) {
                return mid;
            } else if (arr1[mid] < i) {
//            在右边
                begin = mid + 1;
            } else {
//            在左边
                end = mid - 1;
            }
        }
        return -1;
    }

    // 二分法
    // 基于排序的基础之上（没有排序的是无法查找的） 
    public static int arraySearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) {

                return j;
            }
        }
        return -1;
    }


}

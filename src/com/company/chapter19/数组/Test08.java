package com.company.chapter19.数组;

/*
 数组满了需要扩容
 先新建一个大容量的数组，然后将数组中的数据拷贝过去。
 结论：数组扩容的效率较低，所以在开发中需要尽可能少的进行数组的拷贝，
 减少数组的扩容次叔
 */
public class Test08 {
    public static void main(String[] args) {
//        System.arraycopy();
        //拷贝元
        int[] src = {1, 11, 22, 3, 4};
        // 拷贝到目标
        int[] dest = new int[20]; //初始化一个20的数组

        // 调用方法
//        System.arraycopy(src,1,dest,3,2);
//        for (int i = 0; i < dest.length; i++) {
//            System.out.println(dest[i]);
//
//        }

//        System.arraycopy(src,0,dest,0,src.length);
//
//        for (int i = 0; i < dest.length; i++) {
//            System.out.println(dest[i]);
//
//        }

        // 数组中存储的元素是引用，当然可以拷贝

    }
}

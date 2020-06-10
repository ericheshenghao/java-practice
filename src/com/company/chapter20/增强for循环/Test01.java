package com.company.chapter20.增强for循环;

/*
foreach
 */
public class Test01 {
    public static void main(String[] args) {
        int[] i = {1, 2, 3, 3, 4, 5, 5};
        // 遍历数组
        // 普通for循环
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
        //
//        for ( 元素类型 变量名:数组或集合
//             ) {
//        }

        for (int data : i) {
            System.out.println(data);
        }
    }

}

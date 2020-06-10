package com.company.chapter20.集合.arraylist;

import java.util.ArrayList;
import java.util.List;

/*
1.默认初始化容量10（底层先创建了一个长度为0的数组，当添加第一个元素的时候，初始化容量10）
2、集合底层是一个Object[]数组
3、 arraylist的扩容使用位运算符，是原容量的1.5倍 oldValue+（oldValue>>1）
5、 随机增删效率不高，除非是数组末尾、检索效率高，只要知道内存地址可以快速推算其他位置的元素
6、你用哪个最多？
7、ArrayList集合
 */
public class Test01 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        // 是获取个数
        System.out.println(list1.size());
        // 指定初始化容量
        List list2 = new ArrayList(20);

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(11);
        // 100 二进制转成10进制：100右边移动一位 00000010（2） 4/2

        System.out.println(list1.size());


    }
}

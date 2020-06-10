package com.company.chapter20.集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
List中常用的方法
存储元素特点；有序，可重复，存储一个1还可以再存储1
2、 Collection接口的子接口，有自己特有的方法
add(int index，E element)
get(Object o)
indexOf()
lastIndexOf()
set()

 */
public class Test01 {
    public static void main(String[] args) {
        // 创建list类型的集合
        List list = new ArrayList();

        // 默认向集合尾部添加元素
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");
        // 再列表指定位置插入元素
        // 这个方法使用不多 效率低
        list.add(1, "King");


        // 迭代
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }

        // 根据下表获取元素
        Object fistObj = list.get(0);
        // 有下标，所以有特殊的遍历方式
        for (int i = 0; i < list.size(); i++) {
            Object o1 = list.get(i);
            System.out.println(o1);
        }

        System.out.println(list.lastIndexOf("C")); //

        // 删除指定下标的元素
        // 删除下标为零的元素
        list.remove(0);
        System.out.println(list.size());

        // 修改指定位置的元素
        list.set(2, "soft");

        for (int i = 0; i < list.size(); i++) {
            Object o1 = list.get(i);
            System.out.println(o1);
        }

    }


}
/*
计算机英语
add
delete
update set modify
find query select
 */

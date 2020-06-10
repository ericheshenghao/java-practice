package com.company.chapter20.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
底层是一个哈希表或者散列表的数据结构
数组和单项链表的结合体
数组：查询方面效率很，随机增删方面效率很低
单向链表：再随机增删方面效率较高，在查询方面效率较低
哈希表结合两个的优点，充分发挥了优势
3、门帘、珠珠门帘
// 底层是一个数组
 transient Node<K,V>[] table;

//静态内部类
 static class Node<K,V> implements Map.Entry<K,V> {
        final int hash; //哈希值（哈希值是key的hashcode（）方法的执行结果。哈希值通过hash算法，
        可任意转换成数组的下标）
        final K key; //key
        V value;  //value
        Node<K,V> next; //下一个节点的内存地址
 }
 4、掌握存取

 5、 hashmap特点
  无序、不可重复
  不一定挂到哪个单向链表上
  equals方法保证hashMap集合的key不可重复
  如果key重复了 value会覆盖
  放在hashMap集合key部分的元素其实就是放到hashset集合中了
  所以hashset集合种的元素也需要同时重写hashcode()+equals方法
  6、假设所有的hashcoe（）方法返回值是一个固定值，会导致哈希表变成了纯单项链表，分布不均匀。
    假设所有hashcode（）的值都不一样，那就变成了一维数组了，也是分布不均匀，
   散列分布需要重写hashcode（）有一定的技巧。
  7、重写方法
  8、 默认初始化容量16，加载因子0.75
    达到百分之75开始扩容
  9、
 */
public class Test01 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "zhangsan1");
        map.put(222, "zhangsan2");
        map.put(333, "zhangsan23");
        map.put(222, "zhangsan4");

        System.out.println(map.size());

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> s : set
        ) {
            // 无序不可重复
//            System.out.println(s.);
        }
    }
}

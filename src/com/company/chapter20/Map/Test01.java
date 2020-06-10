package com.company.chapter20.Map;

import com.company.chapter20.单向链表.Test;

import java.util.*;

/*
Map和Collection没有继承关系
键值对方式储存
key和value都是引用树数据类型
key主导地位
3、常用方法
 void clea() 清空
 containsKey() 判断是否包含kry
 containsValue()是否包含value
 Set()
 put()添加键值对
 size() 集合大小
 values()  获取所有的values 返回一个集合
 remove() 根据key删除value
 keySet() 获取所有的key
 Set<Map.entry <K,V>>
  entrySet() 经map集合转换成set集合
 get(key) 返回value

-------------
Map.entry 是静态内部类
 */


public class Test01 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // 添加键值对
        map.put(1, "张三");
        map.put(2, "张三2");
        map.put(3, "张三3");
        map.put(4, "张三4");
        // 通过key获取value
        String vaue = map.get(2);
        System.out.println(vaue);
        System.out.println(map.size());
        // 通过key删除
        map.remove(2);
        // 判断是否包含某个value
        System.out.println(map.containsKey(3));
        // 要重写equals哦
        // 判断是否包含某个key
        System.out.println(map.containsValue("张三3"));

        // 清空集合
//        map.clear();
        // 空否
        System.out.println(map.isEmpty());
        // 所有值
        Collection<String> v = map.values();
        for (String s : v
        ) {
            System.out.println(s);
        }
    }
}

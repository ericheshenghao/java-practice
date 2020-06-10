package com.company.chapter20.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的遍历
 */
public class Test03 {
    public static void main(String[] args) {
        // 获取所有的key，通过遍历key，来遍历value
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "张三2");
        map.put(3, "张三3");
        map.put(4, "张三4");
        // 遍历集合
        // 获取所有的key
        Set<Integer> s = map.keySet();

        Iterator<Integer> it = s.iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(value);
        }

        for (Integer k : s
        ) {
            System.out.println(map.get(k));
        }

        // 第二种方式 Set<Map.entry <K,V>> set= map.entrySet()
        // 以上这个方法是把Map集合全部转换成Set集合
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //遍历
//        Iterator<Map.Entry<Integer,String>> it1 =set.iterator();
//        while (it1.hasNext()){
//             Map.Entry<Integer,String> node = it1.next();
//            System.out.println(node.getKey());
//            System.out.println(node.getValue());
//        }

        // foreach
        // 这种方式效率比较高
        //比较适合于大数据量
        for (Map.Entry<Integer, String> node : set
        ) {
            System.out.println(node.getValue());
        }
    }
}

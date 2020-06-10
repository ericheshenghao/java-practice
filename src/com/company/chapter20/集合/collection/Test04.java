package com.company.chapter20.集合.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
深入collection集合的contains
旁段集合是否包含某个元素
如果包含返回true

调用了 equals方式比较
 */
public class Test04 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        String s1 = new String("abc");

        c.add(s1);
        String s2 = new String("def");
        c.add(s2);
        System.out.println(c.size());

        String x = new String("abc");
        // 底层其实调用了   x.equals(c); string重写了equals 比较的是内容
        x.equals(c);
        System.out.println(c.contains(x));
    }
}

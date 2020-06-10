package com.company.chapter20.集合.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

// 有序可重复
public class Test3 {
    public static void main(String[] args) {
//        Collection c= new ArrayList();
//        c.add(1);
//        c.add(2);
//        c.add(3);
//        c.add(4);
//        Iterator it = c.iterator();
//        while (it.hasNext()){
//            // 存进去什么类型，取出来也是什么类型
//            Object  o =it.next();
//           if(o instanceof  Integer){
//               System.out.println(o);
//           }
//        }
        // hashSet集合：无序不可重复
        Collection c1 = new HashSet();

        c1.add(21);
        c1.add(21);
        c1.add(31);
        c1.add(4190);

        Iterator it = c1.iterator();


        // 不可重复
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}

package com.company.chapter20.增强for循环;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("heelo");
        list.add("hh");
        list.add("kitty");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        //下标方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 使用foreach
        for (String data : list
        ) {
            System.out.println(data);
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);


    }
}

package com.company.chapter20.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Test03 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        //允许
        map.put(null, null);
        System.out.println(map.size());

        map.put(null, 100);
        System.out.println(map.size());

        System.out.println(map.get(null));
    }
}

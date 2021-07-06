package com.日期归档.Y2021M7.Day06.点菜展示表;

import java.util.*;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.日期归档.Y2021M7.Day06.点菜展示表
 * @Description:
 * @date : 2021/7/6 12:51
 */
class Solution {
    // Ceviche 3-1
    //【3 Ceviche  10 Beef Burrito  3 Fried Chicken 5  Water 5 Ceviche 3 Ceviche 】
    // 【  3 Ceviche 3 Ceviche-2  3 Fried Chicken 5  Water 5 Ceviche 10 Beef Burrito】
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, Map<String, Integer>> foodsCnt  = new HashMap<>();
        for (List<String> order : orders) {
               set.add(order.get(2));
               int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map  = foodsCnt.getOrDefault(id, new HashMap<>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id,map);
        }
        int n = set.size();
        List<String> names = new ArrayList<String>();
        for (String name : set) {
            names.add(name);
        }

        // 提取桌号，并按餐桌桌号升序排列
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<Integer>();
        for (int id : foodsCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);

        // 菜名排序
        Collections.sort(names);
        // 填写点菜展示表
        List<List<String>> table = new ArrayList<List<String>>();
        List<String> header = new ArrayList<String>();
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        table.add(header);
        for (int i = 0; i < m; ++i) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<String>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; ++j) {
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;

    }
}
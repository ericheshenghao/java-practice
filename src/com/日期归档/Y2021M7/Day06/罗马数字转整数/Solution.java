package com.日期归档.Y2021M7.Day06.罗马数字转整数;

import java.util.HashMap;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.日期归档.Y2021M7.Day06.罗马数字转整数
 * @Description:
 * @date : 2021/7/6 13:32
 */
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = chars.length -1 ;i >= 0 ;i--){
             Integer current = map.get(chars[i]);
            Integer before;
            if(i-1 >= 0 &&  (before = map.get(chars[i-1])) < current ){
                res -= before;
                i--;
            }

            res += current;
        }
        return res;
    }
}
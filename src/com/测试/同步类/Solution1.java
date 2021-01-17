package com.测试.同步类;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : heshenghao
 * @date : 15:14 2021/1/17
 */
public class Solution1 {
    Vector vector;
    Map<String, String> map ;

   public void Solution(){
     this.map = new ConcurrentHashMap<>(16);
   }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Object object;
//        solution.setVector();
    }
}

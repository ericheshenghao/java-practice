package com.难度归档.笔试;

import java.util.ArrayList;

class Solution1 {
    /**
     *
     * @param num int整型 相加的数字
     * @param itemNum int整型 相加项数
     * @return long长整型
     */

//   static ArrayDeque<Integer> sum_stack=new ArrayDeque<>() ;
    
   static public long sum (int num, int itemNum) {
        // write code here
       int ress =0;
       int res =0;
       ArrayList<Integer> list = new ArrayList<>();
       for (int i = 0; i < itemNum; i++) {

            res = fun(num, i);

            ress+=res;
           list.add(ress);
       }

       return list.stream().reduce(0,Integer::sum);
    }

    static int  fun(int num ,int i){
        double v = num * Math.pow(10, i);
        return new Double(v).intValue();
    }

    public static void main(String[] args) {
        long sum = sum(3, 5);
        System.out.println(sum);
    }
}
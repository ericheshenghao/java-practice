package com.力扣练习.简单.回溯.二进制手表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    int[] times = new int[]{1,2,4,8,1,2,4,8,16,32};
    ArrayList<String> strings = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,00);

        sub(num,0,map);


        strings.forEach(System.out::println);

        return strings;
    }

    private void sub(int num, int start , HashMap<Integer,Integer> time) {
       if(num==0){
           if(time.get(0)>11 || time.get(1)>59){
            return;
           }
           String minute = String.valueOf(time.get(1));
           if(time.get(1)<10){
               minute=  "0"+time.get(1);
           }
           strings.add(time.get(0)+":"+minute);

            return;
       }


        for (int i = start; i < times.length; i++) {
            if(time.get(0)>11 || time.get(1)>59){
                continue;
            }
            HashMap<Integer,Integer> store= (HashMap<Integer, Integer>) time.clone();

            if(i<4){
                   time.put(0,time.get(0)+times[i]);
            }else{
                    time.put(1,time.get(1)+times[i]);
            }
            sub(num-1,i+1,time);
            time=store;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readBinaryWatch(2);

    }
}

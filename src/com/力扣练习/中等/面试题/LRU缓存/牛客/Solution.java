package com.力扣练习.中等.面试题.LRU缓存.牛客;

import java.util.*;


public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    Deque<Integer> deque = null;
    HashMap<Integer,Integer> caches =null;
    int cacheSize;
    public int[] LRU (int[][] operators, int k) {
        // write code here
        deque = new ArrayDeque<Integer>(k);
        caches= new HashMap<Integer,Integer>(k);
        cacheSize =k;
        List<Integer> res= new ArrayList<Integer>();
        for(int[] i:operators){

            if(i[0]==1){
                put(i[1],i[2]);
            }
            if(i[0]==2){
                int s= get(i[1]);
                res.add(s);
            }

        }

        return   res.stream().mapToInt(Integer::valueOf).toArray();

    }

    public int get(int key){
        if(caches.get(key)==null) return -1;
        moveTail(key);
        return caches.get(key);
    }

    public void put(int key,int value){
        if(caches.get(key)!=null){
            caches.put(key,value);
            moveTail(key);
        }

        if(deque.size()==cacheSize){
            int dkey =  deque.poll();
            caches.remove(dkey);
        }
        caches.put(key,value);
        deque.offer(key);
    }

    public void moveTail(int key){
        deque.remove(key);
        deque.offer(key);
    }


}
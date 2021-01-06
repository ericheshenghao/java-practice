package com.难度归档.中等.面试题.LRU缓存;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Deque<Integer> deque = null;
    Map<Integer,Integer> caches =null;
    int cacheSize;
    public LRUCache(int capacity) {
        deque= new ArrayDeque<>(capacity);
        caches=new HashMap<>(capacity);
        cacheSize =capacity;
    }

    public int get(int key) {
       if(caches.get(key)==null) return -1;

        addTailToHead(key);

      return caches.get(key);
    }

    public void put(int key, int value) {
        if (caches.get(key)!=null){
            caches.put(key,value);
            addTailToHead(key);
            return;
        }

        if(deque.size()==cacheSize){
            Integer dkey = deque.poll();
            caches.remove(dkey);
        }
        caches.put(key,value);
        deque.offer(key);

    }

   public void addTailToHead(int key){
       deque.remove(key);
       deque.offer(key);
    }

}

class Test{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2, 6);
        int i = cache.get(1);// 返回  1
//        System.out.println(i);
        cache.put(1, 5);    // 该操作会使得密钥 2 作废
        cache.put(1, 2);
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        int i1 = cache.get(1);// 返回 -1 (未找到)
//        System.out.println(i1);
        int i3 = cache.get(2);// 返回  3
//
//        cache.get(4);

    }
}

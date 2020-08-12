package com.并发编程的艺术.第二章__Java并发机制的底层实现原理;

// 使用循环cas实现原子操作



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  private AtomicInteger atomicInteger  =   new AtomicInteger(0);
  private int i = 0;


    public static void main(String[] args) throws InterruptedException {
       final Counter cas = new Counter();
        ArrayList<Thread> ts = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });

            ts.add(t);
        }
        for (Thread t:ts
             ) {
            t.start();
        }
        for (Thread t:ts
             ) {
            t.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    /**
     * cas 实现线程安全计数器
     */

    private void safeCount() {
        for (;;){
            int i = atomicInteger.get();
            boolean b = atomicInteger.compareAndSet(i, ++i);
            if(b){
                break;
            }
        }
    }

    // 非线程安全
    private void count() {
       i++;
    }
}

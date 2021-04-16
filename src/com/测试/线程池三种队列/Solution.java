package com.测试.线程池三种队列;

import java.util.concurrent.*;

/**
 * @author : heshenghao
 * @date : 21:42 2021/1/28
 */
public class Solution {

    public static void main(String[] args) {

    ExecutorService cachedThreadPool = new ThreadPoolExecutor(
            4, Runtime.getRuntime().availableProcessors() * 2,
            0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), r -> new Thread(r, "ThreadTest"));


        ExecutorService cachedThreadPool1 = new ThreadPoolExecutor(
                4, Runtime.getRuntime().availableProcessors() * 2,
                0, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(32), r -> new Thread(r, "ThreadTest"));
    }
}

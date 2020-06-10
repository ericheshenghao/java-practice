package com.company.chapter20.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//JUC 包下的 并发包
/*
实现callable接口
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个未来任务类对象
        // 参数对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {  // call 相当于run方法 只不过有返回值
                System.out.println("begin ");
                Thread.sleep(1000 * 10);
                System.out.println("end");
                int a = 100;
                int b = 200;
                return a + b; // 自动装箱（300结果Integer类型）
            }
        });

        // 创建线程对象
        Thread t = new Thread(task);
        t.start();

        // 获取线程结果
        // 这里会阻塞主线程，因为为了等待另一个线程的执行结果
        Object o = task.get();

        System.out.println("hello world");

    }
}

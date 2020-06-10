package com.company.chapter20.多线程;

/*
线程的sleep方法
1、静态方法
2、参数是毫秒
3、让当前进程进入睡眠，进入阻塞状态，放弃cpu占有时间片
4、可以做到间隔一定的时间执行特定的代码
 */
public class Test06 {
    public static void main(String[] args) {

//      try {
//          Thread.sleep(1000*5);
//      }catch(Exception e){
//          e.printStackTrace();
//      };

        System.out.println("hello");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
        }

    }
}

package com.日期归档.l2021年02月08日.threadLocal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : heshenghao
 * @date : 21:17 2021/3/1
 */
public class Solution {
    private static final int HASH_INCREMENT = 0x61c88647;
    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    public static void main(String[] args)   {


//        List<Integer> integers = testHashCode();
//        for (Integer integer : integers) {
//            System.out.println(integer);
//            testMagicHash(16,integer);
//        }

//        testLocalMap();
        hashCodes();


    }
    public static Integer length =16;

      static void hashCodes(){
        int hashCode = 0;
        for(int i=0; i< length; i++){
            hashCode = i * HASH_INCREMENT+HASH_INCREMENT;//每次递增HASH_INCREMENT
            System.out.print(hashCode & (length-1));
            if(i==5) length = 32;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(" ");
        }

    }



    static void testLocalMap(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 5; i++) {
            int j = i;
            Thread thread = new Thread(() -> {
                threadLocal.set("threadLocal"+j);
            });
            thread.start();
        }
    }


    static void testMagicHash(int n,int integer){
            System.out.println(integer & (n - 1));
    }

   static List<Integer> testHashCode()  {
        List<ThreadLocal<String>> list = new ArrayList<>();
        List<Integer> hashCode  = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("threadLocal"+i);
            list.add(threadLocal);
            try {
                getField(threadLocal,hashCode);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return  hashCode;

    }

    static  void getField(ThreadLocal threadLocal,List<Integer> hashCode) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends ThreadLocal> aClass = threadLocal.getClass();
        Field field = aClass.getDeclaredField("threadLocalHashCode");
        field.setAccessible(true);
        Object o = field.get(threadLocal);
         hashCode.add((Integer) o);

    }
}

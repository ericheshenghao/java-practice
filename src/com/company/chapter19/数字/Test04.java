package com.company.chapter19.数字;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.Random;

/*
编写程序生成五个不重复的随机数。重复的话重新生成
放到数组里面
 */
public class Test04 {
    public static void main(String[] args) {
        Random num = new Random();
        int[] contain = new int[5];

        int i = 0;
        while (i < 5) {
            int num1 = num.nextInt(10);
            if (isNotContain(contain, num1)) {
                contain[i] = num1;
                i++;
            }

        }

        for (int j = 0; j < contain.length; j++) {
            System.out.println(contain[j]);
        }

    }


    public static boolean isNotContain(int[] a, int b) {

        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                return false;
            }
        }

        return true;
    }

}

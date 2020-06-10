package com.company.chapter19.数字;

import java.util.Random;

/*
随机数
 */
public class Test03 {
    public static void main(String[] args) {
        Random random = new Random();
        // 随机产生一个int类型取值范围内的数字
        int num1 = random.nextInt();
        System.out.println(num1);
        // 产生【0-100】之间的随机数
        // 表述下一个为101
        int num2 = random.nextInt(101);
        System.out.println(num2);
    }
}

package com.lamda表达式.第二章.校验.质数校验;

import java.util.stream.IntStream;

public class Test01 {

    public static void main(String[] args) {
        int num = 5;
        boolean prime = isPrime(num);
        System.out.println("num "+num+(prime?" 是质数":" 不是质数"));

    }
    public static boolean isPrime(int num){
        int limit = (int) (Math.sqrt(num) + 1);
        return num==2 || num>1 && IntStream.rangeClosed(2,limit)
                .noneMatch(divisor->num % divisor ==0);
    }
}

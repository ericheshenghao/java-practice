package com.lamda表达式.第二章.归约操作.利用peek方法对流进行调试;

import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {

    }

    public int sumDoublesDivisibleBy3(int start,int end){
        return IntStream.rangeClosed(start,end)
                .map(n->n*2)
                .filter(n->n%3==0)
                .sum();
    }

    public int sumDoublesDivisibleBy33(int start,int end){
        return IntStream.rangeClosed(start,end)
                .map(n->{
                    System.out.println(n);
                    return n;
                })
                .map(n->n*2)
                .filter(n->n%3==0)
                .sum();
    }

    public int sumDoublesDivisibleBy333(int start,int end){
        return IntStream.rangeClosed(start,end)
                .peek(n->System.out.printf("original: %d%n",n))
                .map(n->n*2)
                .peek(n->System.out.printf("double: %d%n",n))
                .filter(n->n%3==0)
                .peek(n->System.out.printf("filter: %d%n",n))
                .sum();
    }



}


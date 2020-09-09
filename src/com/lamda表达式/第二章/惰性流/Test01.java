package com.lamda表达式.第二章.惰性流;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {
//        OptionalInt first = IntStream.range(100, 200)
//                .map(n -> n * 2)
//                .filter(n -> n % 3 == 0)
//                .findFirst();
//        System.out.println(first);
        Test test = new Test();
        test.dosome();

    }



}
class Test{
    void  dosome(){
        OptionalInt first = IntStream.range(100, 200)
                .map(this::multByTwo)
                .filter(this::divByThree)
                .findFirst();
        System.out.println(first);
    }

    public int multByTwo(int n){
        System.out.printf("Inside multByTwo with arg %d%n",n);
        return n*2;
    }
    public boolean divByThree(int n){
        System.out.printf("Inside divByThree with arg %d%n",n);
        return n%3==0;
    }
}

package com.company.chapter20.泛型;

import com.company.chapter20.单向链表.Test;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Test03<E> {
    public void dosome(E o) {
        System.out.println(o);

    }

    public static void main(String[] args) {
        // 这里指定了泛型为string
        Test03<String> gt = new Test03<>();
        // 这里之恩传string
        gt.dosome("123b ");

        Test03<Integer> gt1 = new Test03<>();
        gt1.dosome(2);

    }
}

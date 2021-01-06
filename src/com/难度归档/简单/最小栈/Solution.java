package com.难度归档.简单.最小栈;

import java.util.ArrayDeque;

class MinStack {

    ArrayDeque<Integer> arrays =new ArrayDeque<>();
    ArrayDeque<Integer> min_stack=new ArrayDeque<>() ;
    /** initialize your data structure here. */
    public MinStack() {

        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
           arrays.addFirst(x);
           if(x<min_stack.getFirst()) min_stack.push(x);
           else min_stack.push(min_stack.getFirst());
    }

    public void pop() {
          arrays.pop();
          min_stack.pop();
    }

    public int top() {
        Integer first = arrays.getFirst();
        return first;
    }

    public int getMin() {
       return min_stack.getFirst();
    }
}

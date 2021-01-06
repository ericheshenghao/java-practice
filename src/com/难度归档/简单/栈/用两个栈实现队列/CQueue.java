package com.难度归档.简单.栈.用两个栈实现队列;

import java.util.Stack;

class CQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public CQueue() {

    }

    public void appendTail(int value) {

        if(stack1.isEmpty()) stack1.push(value);

        while (!stack1.isEmpty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        stack1.push(value);

        while (!stack2.isEmpty()){
            Integer pop = stack2.pop();
            stack1.push(pop);
        }


    }

    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        Integer pop = stack1.remove(0);
        return  pop;
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
      obj.appendTail(3);
     int param_2 = obj.deleteHead();
        int param_3 = obj.deleteHead();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
package com.日期归档.l2021年02月07日.用两个栈实现队列;

import java.util.Stack;

/**
 * @author : heshenghao
 * @date : 23:13 2021/2/8
 */
class CQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.isEmpty()?-1:s2.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

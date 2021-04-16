package com.日期归档.l2021年02月08日.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : heshenghao
 * @date : 14:03 2021/3/1
 */
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    Stack<Integer> stack;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
        stack= new Stack<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        queue.add(value);
        queue.poll();
        queue.remove();
        queue.peek();


        deque.push(value);
        deque.pop();

        deque.add(value);
        deque.offer(value);
        deque.remove();
        deque.poll();
        deque.peek();

        deque.addFirst(value);
        deque.addLast(value);
        deque.offerFirst(value);
        deque.offerLast(value);
        deque.removeFirst();
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
        deque.peekFirst();
        deque.peekLast();
        deque.getFirst();
        deque.getLast();




        while(!deque.isEmpty() && deque.peekLast() < value){
            deque.removeLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
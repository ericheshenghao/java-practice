package com.company.chapter20.异常;

public class Test15 {
    public static void main(String[] args) {
        Mystack stack = new Mystack();

        try {
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());

            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;

    }
}

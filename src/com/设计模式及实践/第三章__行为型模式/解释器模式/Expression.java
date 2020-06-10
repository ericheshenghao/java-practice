package com.设计模式及实践.第三章__行为型模式.解释器模式;

import java.util.Stack;

public interface Expression {
    public float interpret();
}

class Number implements Expression
{
    private float number;
    public Number (float number){
        this.number = number;
    }
    @Override
    public float interpret() {
        return number;
    }
}

class Plus implements Expression{
    Expression left;
    Expression right;

    public  Plus(Expression left,Expression right){
        this.left = left;
        this.right =right;
    }

    @Override
    public float interpret() {
        return left.interpret() + right.interpret();
    }
}

class Minus implements Expression{
    Expression left;
    Expression right;

    public  Minus(Expression left,Expression right){
        this.left = left;
        this.right =right;
    }

    @Override
    public float interpret() {
        return right.interpret() - left.interpret();
    }
}

class  Evaluator{
    public float evaluate(String expression){
        Stack<Expression> stack = new Stack<Expression>();
        float result = 0;
        for (String token :
                expression.split(" ")) {
            if(isOperator(token))
            {
                Expression exp = null;
                if(token.equals("+")){
                    exp = stack.push(new Plus(stack.pop(),stack.pop()));

                }else if(token.equals("-"))
                    exp= stack.push(new Minus(stack.pop(),stack.pop()));
                if(null!=exp){
                    result = exp.interpret();
                    stack.push(new Number(result));
                }
            }
            if(isNumber(token)){
                stack.push(new Number(Float.parseFloat(token)));
            }

        }

        return  result;
    }

    private boolean isNumber(String token){
        try {
            Float.parseFloat(token);
            return true;
        }catch(Exception e){
           return false;
        }
    }

    private boolean isOperator(String token){
        if(token.equals("+")||token.equals("-")) return true;
        return false;
    }

    public static void main(String s[]){
            Evaluator eval = new Evaluator();
            System.out.println(eval.evaluate("2 3 +"));
            System.out.println(eval.evaluate("4 3 -"));
            System.out.println(eval.evaluate("4 3 - 2 +"));
    }
}
package com.力扣练习.笔试.英泰来.丽丽的计算器;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();

        String s = line.replaceAll("\"", "");

        Main main = new Main();
        int calc = main.calc(s);

        System.out.println(calc);
    }



    public  int calc(String s) {
           Stack<Integer> numStack = new Stack<>();

           char lastOp ='+';
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' ') continue;

            if(Character.isDigit(arr[i])){
                int temp = arr[i]-'0';
                while (++i <arr.length && Character.isDigit(arr[i])){
                    temp = temp*10+(arr[i]-'0');
                }
                i--;

                if(lastOp == '+') numStack.push(temp);
                else if(lastOp=='-') numStack.push(-temp);
                else {

                        numStack.push(res(lastOp,numStack.pop(),temp));

                }
            } else lastOp = arr[i];
        }
        int ans =0;
        for (int num: numStack) ans +=num;
        return ans;
    }

    private static int res(char lastOp, int a, int b) {
        if(lastOp=='*') return a*b;
        else if(lastOp=='/') return a/b;
        else if(lastOp=='+') return a+b;
        else  return  a-b;
    }
}
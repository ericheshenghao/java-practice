package com.company.chapter20.异常;

/*
 推出jvm之后，finally就不执行了
 */
public class Test12 {

    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.exit(0);
        } finally {
            System.out.println("finally");
        }
    }
}

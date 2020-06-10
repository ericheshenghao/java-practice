package com.company.chapter20.异常;

/*
finally 语句
finally 一定会执行
 */
public class Test11 {
    public static void main(String[] args) {
        /*
         先执行 try 再执行finally 最后执行 return
         */
        try {
            System.out.println("try...");
            return;
        } finally {
            System.out.println("finally");
        }
        // 没有执行机会
//        System.out.println();
    }
}

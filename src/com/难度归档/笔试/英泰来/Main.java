package com.难度归档.笔试.英泰来;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        int select = select(n, 1);
        
        System.out.println(select);
    }

    public static int select(int n,int dept) {
        if(n <0) return dept-2;
        
        int select = select(n-dept, dept + 1);

        return select;
    }
}
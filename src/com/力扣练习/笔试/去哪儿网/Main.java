package com.力扣练习.笔试.去哪儿网;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m = 0, n = 0;
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();

        }

        int select = select(m, n);
        System.out.println(select);

    }

    public static int select(int m, int n) {
        if (n > m) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return select(m - 1, n - 1) + select(m - 1, n);
    }
}
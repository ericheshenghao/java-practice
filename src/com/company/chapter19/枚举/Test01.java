package com.company.chapter19.枚举;

/*
    分析一下程序，在設計方面有什麽問題
    // 这个案例
 */
public class Test01 {
    public static void main(String[] args) {
        int res = divide(10, 0);
        System.out.println(res == 0 ? "执行失败" : "执行成功");
    }

    /**
     * 計算兩個int數據的商，計算成功返回1，計算失敗返回0
     *
     * @param a
     * @param b
     * @return 返回 1表示成功
     */
    public static int divide(int a, int b) {
        try {
            int c = a / b;
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}

enum exception {

}
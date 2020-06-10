package com.company.chapter20.异常;

/*

 */
public class Test13 {
    public static void main(String[] args) {
        int re = m();
        System.out.println(re); //100
    }

    /*
        语法规则（不能破坏的规则）
           必须遵循自上而下的顺序（亘古不变）
           必须返回100
           还有一条规则，return 一旦执行，方法必须结束
     */
    private static int m() {
        int i = 100;
        try {
//            // 保证最后执行
//            return i;
        } finally {
            i++;
            // 保证最后执行
            return i;
        }
    }
}

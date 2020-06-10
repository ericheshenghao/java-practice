package com.company.chapter19.枚举;

public class Test02 {
    public static void main(String[] args) {
        Result r = divide(10, 2);
        System.out.println(r == Result.SUCCESS ? "成功" : "失败");
    }


    public static Result divide(int a, int b) {
        try {
            int c = a / b;
            return Result.SUCCESS;
        } catch (Exception e) {
            return Result.FAIL;
        }
    }
}
// 枚举

enum Result {
    // 枚举编译之后也是生成class文件
    // 枚举也是一种引用数据类型
    // 可以看作是常量
    SUCCESS, FAIL
}
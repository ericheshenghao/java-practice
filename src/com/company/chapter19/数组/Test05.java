package com.company.chapter19.数组;

/*
mian 方法上面的一维数组有什么用
谁负责调用
jvm调用main方法的时候，会自动传一个String数组出来
 */
public class Test05 {
    // 回传一个String数组过来 引用数据类型
    // 通过测试得出：args不是null
    public static void main(String[] args) {
        System.out.println(args.toString());

        //相当于传过来这个
        String[] strs = new String[0];
        System.out.println(strs.length);
        // 这个数组什么时候会有值呢
        // 其实这个数组是留给客户的，用户可以在控制太上输入参数，这个参数会自动转为 String[] args
        // 例如这样运行程序： java Text05 avc def xyz
        // 那么这个时候jvm会自动将通过空格的方式进行分离，分离完成后，自动放到数组中
        // 所以主要是用来接收用户的输入参数的
        String username = args[0];

        String password = args[1];
        if ("admin".equals(username) && "123".equals(password)) {
            // 可以防止出现空指针异常
        }

    }
}

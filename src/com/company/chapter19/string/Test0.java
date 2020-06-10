package com.company.chapter19.string;

public class Test0 {
    public static void main(String[] args) {
        // String 类常用方法
        // 1.char chaAt(int index)

        char c = "中国人".charAt(1); //中国人是一个字符串，
        System.out.println(c);

        //
        System.out.println("abcd".compareTo("abce")); //比较大小 10-10 =0
        System.out.println("abc".compareTo("abcd")); // 8-9 =-1
        System.out.println("abce".compareTo("abcd")); //前大后小  9-8=1

        //
        System.out.println("hellow world.java".contains("java"));
        // endwith
        // 判断是否以某个字符串结尾
        System.out.println("abc".equals("abc"));

        // 判断两个字符串是否相等，忽略大小写
        System.out.println("ABC".equalsIgnoreCase("abc"));

        // 将字符串对象转换成字节数组
        byte[] bytes = "abcdf".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        // 旁段某个字符串在当前字符串中第一次出现处的索引
        System.out.println("sdjavahfjkhasfskjhfjkshfsfjhmnmcvhsoraclec".indexOf("java"));

        // 判断数组长度是length属性，判断字符串长度是length()方法
        System.out.println("abc".length());

        //12. String的父接口就是 charsequence
        System.out.println("http://www.baidu.com".replace("http://", "https://"));

        //13.
        System.out.println("1980-10-11".split("-")); // 拆分出来一个数组

        String param = "name=zhangsan&password=123";
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]);
        }

        //14. 旁段某个字符串是否以某个子字符串开始
        System.out.println("http://".startsWith("http"));

        // 15. substring 截取字符串
        System.out.println("http://www.baidu.com".substring(7));

        // 16.substring(开始，结束)
        System.out.println("http://www.baidu.com".substring(7, 10));

        // 17. toCharArray

        // 18.toLowerCase()
        System.out.println("ABC".toLowerCase());

        //19 toupercase
        System.out.println("abc".toUpperCase());

        // 20. trim
        //去除字符串前后的空白
        System.out.println("            heloo   world    dfs  ".trim());

        //21. valueOf
        // 不是字符串的东西转换为字符串
        Customer s1 = new Customer();
        System.out.println(String.valueOf(s1));

        // system.out.println 本质上调用了valueOf方法，所以输出的任何数据都是字符串。
    }
}

class Customer {
}

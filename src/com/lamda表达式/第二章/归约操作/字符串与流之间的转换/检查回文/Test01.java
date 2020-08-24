package com.lamda表达式.第二章.归约操作.字符串与流之间的转换.检查回文;

public class Test01 {
    public static void main(String[] args) {

        boolean hfsbbsfh = isPalindrome("hfsbbsfh");
        System.out.println(hfsbbsfh);

    }

    public static boolean isPalindrome(String s ){
        String forward = s.toLowerCase().codePoints().filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append).toString();

        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}

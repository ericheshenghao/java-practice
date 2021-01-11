package com.日期归档.l2021年01月11日.用Rand7实现Rand10;

/**
 * @author : heshenghao
 * @date : 20:33 2021/1/11
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
//class Solution extends SolBase {
//    public int rand10() {
//        while(true) {
//            int num = (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
//            if(num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
//        }
//    }
//}
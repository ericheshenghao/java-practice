package com.难度归档.笔试.最大的10个数;

/**
 * @author : heshenghao
 * @date : 19:21 2020/11/29
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 选出其中最大的10个数
     * @param input int整型ArrayList 整数
     * @return int整型ArrayList
     */
    public ArrayList<Integer> top10 (ArrayList<Integer> input) {
        // write code hereshuzi
        ArrayList<Integer> list = new ArrayList<>(10);
        input.sort((o1, o2) -> o2-o1);
        for (int i = 9; i >= 0; i--) {
            list.add(input.get(i));
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {11,22,33,44,55,66,88,77,3,9,999,10000,3456};
        ArrayList<Integer> list = new ArrayList<>();

        for (int anInt : ints) {
            list.add(anInt);
        }
        solution.top10(list);
    }
}
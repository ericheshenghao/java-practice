package com.日期归档.l2021年01月26日.把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author : heshenghao
 * @date : 18:46 2021/1/26
 */
class Solution {
    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1) )
                .map(i -> i.toString()).reduce("", String::concat);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minNumber(new int[]{3,30,34,5,9});
    }
}
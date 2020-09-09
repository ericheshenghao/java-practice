package com.lamda表达式.第五章.lambda表达式与效果等同于final变量;

import java.util.Arrays;
import java.util.List;

public class Test01 {
   static List<Integer> nums = Arrays.asList(3,1,43,4,5,1,23);

    public static void main(String[] args) {
        int total =0;
        for (int num : nums) {
            total+=num;
        }
        total=0;
        total += nums.stream().mapToInt(n -> n).sum();

        total=0;
        total += nums.stream().mapToInt(n -> n).sum();
    }
}

package com.lamda表达式.第二章.汇总统计;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class summartStatic方法 {
    public static void main(String[] args) {
        DoubleSummaryStatistics statistics = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
        
    }
}

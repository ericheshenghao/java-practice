package com.lamda表达式.第四章.利用比较器实现排序;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Test02 {
    private static List<Golfer>  golfers = Arrays.asList(
            new Golfer("张","三",68),
            new Golfer("李","四",70),
            new Golfer("王","五",70),
            new Golfer("周","六",68),
            new Golfer("何","七",70),
            new Golfer("王","八",67)
    );

    public static List<Golfer> sortByScoreThenLastThenFirst(){
        return golfers.stream()
                .sorted(comparingInt(Golfer::getScore).reversed()
                      .thenComparing(Golfer::getLast)
                        .thenComparing(Golfer::getFirst)
                ).collect(toList());

    }

    public static void main(String[] args) {
        List<Golfer> golfers = sortByScoreThenLastThenFirst();
         golfers.forEach(golfer -> System.out.println(golfer ));
    }


}

class Golfer{
    private String first;
    private String last;
    private int score;

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Golfer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", score=" + score +
                '}';
    }
}

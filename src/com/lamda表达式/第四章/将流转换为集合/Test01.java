package com.lamda表达式.第四章.将流转换为集合;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    List<String> strings = Stream.of("mr1","mr2","mr3","mr4","mr5","mr6","mr7","mr8")
            .collect(Collectors.toList());

    Set<String> villains = Stream.of("mr1","mr2","mr3","mr3").collect(Collectors.toSet());

    List<String> actors =   Stream.of("mr1","mr2","mr3","mr4","mr5","mr6","mr7","mr8")
            .collect(Collectors.toCollection(LinkedList::new));

    String[]  wannabes =  Stream.of("mr1","mr2","mr3","mr4","mr5","mr6","mr7","mr8")
            .toArray(String[]::new);




    public static void main(String[] args) {

    }
}

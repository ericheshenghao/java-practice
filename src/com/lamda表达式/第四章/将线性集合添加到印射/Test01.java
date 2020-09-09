package com.lamda表达式.第四章.将线性集合添加到印射;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test01 {
    List<Book> books = Arrays.asList(
            new Book(1,"第一本书",49.99),
            new Book(2,"第二本书",49.99),
            new Book(3,"第三本书",39.99),
            new Book(4,"第四本书",27.64),
            new Book(5,"第五本书",23.76)
    );

    Map<Integer,Book> bookMap = books.stream()
            .collect(Collectors.toMap(Book::getId,b->b));
    Map<Integer,Book> bookMaps = books.stream()
            .collect(Collectors.toMap(Book::getId, Function.identity()));


}




class Book{
    private int id;
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
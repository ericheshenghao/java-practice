package com.lamda表达式.第二章.归约操作.reduce方法的一般形式;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book(1, "书本1"), new Book(2, "书本2"), new Book(3, "书本3"));

        HashMap<Integer, Book> reduce = books.stream()
                .reduce(new HashMap<Integer, Book>(),
                        (map, book) -> {
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        }
                );
        reduce.forEach((k,v)->System.out.println(k+": "+v));
    }
}

class Book{
    private Integer id;
    private String  title;

    public Book(int i, String title) {
        this.id = i;
        this.title = title;
    }

 

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

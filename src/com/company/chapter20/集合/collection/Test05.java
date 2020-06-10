package com.company.chapter20.集合.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Test05 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        // 创建用户对象
        User u1 = new User("jack");
        User u2 = new User("jack");
        c.add(u1);
        System.out.println(c.contains(u2));
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public User() {
    }
}
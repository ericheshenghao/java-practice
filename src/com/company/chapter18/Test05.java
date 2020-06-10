package com.company.chapter18;

import java.util.Objects;

public class Test05 {
    public static void main(String[] args) {
//        Address addr = ;
        User u = new User("zhangsan", new Address("北京", "大星", "2134"));
        User u1 = new User("zhangsan", new Address("北京", "大星", "2134"));

        System.out.println(u.equals(u1));
    }
}

class User {
    String name;
    Address addr;

    public User() {
    }

    public User(String name, Address addr) {
        this.name = name;
        this.addr = addr;
    }

    // 这个equals旁段的是user对象和user对象是否相同
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof User)) return false;
        if (this == obj) return true;
        User u = (User) obj;
        return this.name.equals(u.name) && this.addr.equals(u.addr);
    }
}

class Address {
    String city;
    String street;
    String zipcaode;

    public Address() {
    }

    public Address(String city, String street, String zipcaode) {
        this.city = city;
        this.street = street;
        this.zipcaode = zipcaode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcaode, address.zipcaode);
    }


}
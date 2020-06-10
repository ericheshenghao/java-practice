package com.company.chapter20.IO流.对象流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
一次序列化多个对象
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "zhansn"));
        userList.add(new User(2, "lisi"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users"));
        // 集合的序列化
        oos.writeObject(userList);

        oos.flush();
        oos.close();
    }
}

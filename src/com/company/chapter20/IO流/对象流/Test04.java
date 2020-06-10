package com.company.chapter20.IO流.对象流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users"));
        Object obj = ois.readObject();
        System.out.println(obj instanceof List);
        List<User> user = (List<User>) obj;

        for (User u : user
        ) {
            System.out.println(u);
        }
        ois.close();
    }
}

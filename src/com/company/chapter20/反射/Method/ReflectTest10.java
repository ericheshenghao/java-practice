package com.company.chapter20.反射.Method;

import com.company.chapter20.反射.Method.Service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
通过反射机制调用方法
 */
public class ReflectTest10 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        UserService userService = new UserService();
        boolean login = userService.login("admin", "123");
        System.out.println(login);
        // 使用反射机制调用
        Class userServiceClass = Class.forName("com.company.chapter20.反射.Method.Service.UserService");
        //创建对象
        Object o = userServiceClass.newInstance();
        // 获取method
        Method loginMethod = userServiceClass.getDeclaredMethod("login", String.class, String.class);
        //调用方法
        // 对象 方法 参数 返回值
        // 最重要的方法
        // 四要素

        Object value = loginMethod.invoke(o, "admin", "123");

        System.out.println(value);
    }
}

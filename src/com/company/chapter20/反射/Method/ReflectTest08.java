package com.company.chapter20.反射.Method;



import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest08 {
    public static void main(String[] args) throws Exception {
        Class userServiceClass = Class.forName("com.company.chapter20.反射.Method.Service.UserService");

        Method[] methods = userServiceClass.getDeclaredMethods();

        for (Method method : methods
        ) {

            System.out.println(Modifier.toString(method.getModifiers()));
            // 获取返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            // 方法的修饰符列表
            Class[] classes = method.getParameterTypes();
            for (Class type : classes
            ) {
                System.out.println(type.getSimpleName());
            }
        }
    }
}

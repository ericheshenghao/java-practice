package com.company.chapter20.反射;

/*
  能干神魔？
  必须保证无参构造存在
 */
public class ReflectTest02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射机制，获取class，通过class实例化对象
        Class c = Class.forName("com.company.chapter20.反射.User");
        try {
            Object o = c.newInstance();
            System.out.println(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

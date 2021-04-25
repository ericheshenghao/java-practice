package cn.siques.Rpc测试;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : heshenghao
 * @date : 15:06 2021/4/24
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("cn.siques.手写RPC框架.server.service.impl.HelloService");
        aClass.getMethod("sayHello").invoke(aClass);
    }
}

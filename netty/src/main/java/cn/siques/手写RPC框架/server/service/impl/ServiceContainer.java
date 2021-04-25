package cn.siques.手写RPC框架.server.service.impl;


import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象容器
 * @author : heshenghao
 * @date : 15:11 2021/4/24
 */
public class ServiceContainer {
    static Properties properties;
    private static ConcurrentHashMap<Class<?>,Object>  concurrentHashMap= new ConcurrentHashMap<>();

    static {

        try (InputStream is = ServiceContainer.class.getResourceAsStream("/application.properties")) {
            properties = new Properties();
            properties.load(is);
            Set<String> names = properties.stringPropertyNames();
            System.out.println(names);
            for (String name:names){
                if(name.endsWith("Service")){
                    String clazzImpl = properties.getProperty(name);
                    Class<?> aClass = Class.forName(clazzImpl);
                    Object o =  aClass.newInstance();
                    concurrentHashMap.put(Class.forName(name),o);
                }
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getService(Class<?> clazz){
        return concurrentHashMap.get(clazz);
    }
}

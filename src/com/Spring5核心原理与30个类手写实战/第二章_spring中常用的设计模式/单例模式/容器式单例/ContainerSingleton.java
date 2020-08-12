package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.单例模式.容器式单例;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc =new ConcurrentHashMap<String,Object>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj  = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }
}

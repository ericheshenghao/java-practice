package cn.siques.手写RPC框架.server.service.impl;

/**
 * @author : heshenghao
 * @date : 15:01 2021/4/24
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("hello, "+name);
        return "调用成功";
    }
}

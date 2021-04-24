package cn.siques.聊天室.server.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
        int i = 1 / 0;
        return "你好, " + msg;
    }

    @Override
    public int doSome(String name) {
        return 0;
    }
}
package cn.siques.手写RPC框架.client;

import cn.siques.手写RPC框架.server.service.impl.HelloService;
import io.netty.channel.ChannelFuture;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : heshenghao
 * @date : 21:10 2021/4/24
 */
public class RpcClientManage {
    public static void main(String[] args) {
        HelloService helloService = RpcClient.doProxyService(HelloService.class);
        helloService.sayHello("何");
    }
}

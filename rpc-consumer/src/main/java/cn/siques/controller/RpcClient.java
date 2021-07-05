package cn.siques.controller;


import cn.siques.handler.RpcResponseHandler;
import cn.siques.message.RpcRequestMsg;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.DefaultPromise;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

 
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.proxy
 * @Description:
 * @date : 2021/7/5 14:13
 */
@Component
public class RpcClient {
    
    @Autowired
    ApplicationContext applicationContext;

    public <T> T doMethod(final Class<?> interfaceClass){
         Enhancer enhancer = new Enhancer();
         enhancer.setClassLoader(interfaceClass.getClassLoader());
         enhancer.setSuperclass(interfaceClass);
         enhancer.setCallback(new MethodInterceptor() {
             @Override
             public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                 RpcRequestMsg req = new RpcRequestMsg();
                 req.setInterfaceName(interfaceClass.getName());
                 req.setMethodName(method.getName());
                 String id = UUID.randomUUID().toString();
                 req.setSequenceId(id);
                 req.setArgs(objects);
                 req.setArgType(method.getParameterTypes());
                 Channel channel = (Channel) applicationContext.getBean("channel");
                  channel.writeAndFlush(req);
                 DefaultPromise<Object> promise = new DefaultPromise<>(channel.eventLoop());
                 // 存入 请求id 与 未来结果的对应关系
                 RpcResponseHandler.PROMISES.put(id,promise);
                 // 同步等待 30 秒
                 promise.await(30, TimeUnit.SECONDS);
                 if(promise.isSuccess()){
                     return  promise.getNow();
                 }else {
                     throw new RuntimeException(promise.cause());
                 }
             }
         });
        Object o = enhancer.create();
        return (T) o;
     }
}

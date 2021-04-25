package cn.siques.手写RPC框架.client;

import cn.siques.手写RPC框架.message.RpcRequestMsg;
import cn.siques.手写RPC框架.codec.MessageCodec;
import cn.siques.手写RPC框架.codec.ProtoFrameDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultPromise;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author : heshenghao
 * @date : 14:36 2021/4/24
 */
public class RpcClient {

    static Channel channel;
    private static  final Object LOCK = new Object();

    public static <T> T doProxyService(final Class<?> interfaceClass){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(interfaceClass.getClassLoader());
        enhancer.setSuperclass(interfaceClass);
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param o 被代理的对象（需要增强的对象）
             * @param method 被拦截的方法（需要增强的方法）
             * @param args 方法入参
             * @param methodProxy 用于调用原始方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("toString")) return null;
                RpcRequestMsg msg = new RpcRequestMsg();
                msg.setInterfaceName(interfaceClass.getName());
                msg.setMethodName(method.getName());
                msg.setReturnType(method.getReturnType());
                msg.setArgType(method.getParameterTypes());
                msg.setArgs(args);
                String id = UUID.randomUUID().toString();
                msg.setSequenceId(id);
                System.out.println(msg);
                getChannel().writeAndFlush(msg);
                DefaultPromise<Object> promise = new DefaultPromise<>(getChannel().eventLoop());
                RpcResponseHandler.PROMISES.put(id,promise);

//                promise.addListener(future -> {
//
//                });
                // 等待结果
                promise.await();
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

     public static Channel getChannel(){
         if(channel!=null) {
             return channel;
         } else{
             synchronized (LOCK){
                 if(channel!=null) {
                     return channel;
                 }
                    initChannel();
             }
         }
         return channel;
     }


    private static void initChannel() {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ProtoFrameDecoder());
                            ch.pipeline().addLast(new MessageCodec());
                            ch.pipeline().addLast(new LoggingHandler());
                            ch.pipeline().addLast(new RpcResponseHandler());
                        }
                    });
            // 这里要同步，否则channel 没有就绪
            channel = bootstrap.connect("localhost", 8081).sync().channel();

            channel.closeFuture().addListener(future -> {
                group.shutdownGracefully();
            });

        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
    }
}

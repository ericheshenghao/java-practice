package cn.siques.聊天室.client;


import cn.siques.message.RpcRequestMessage;
import cn.siques.protocol.MessageCodecSharable;
import cn.siques.protocol.ProcotolFrameDecoder;
import cn.siques.protocol.SequenceIdGenerator;
import cn.siques.聊天室.client.handler.RpcResponseMessageHandler;
import cn.siques.聊天室.server.service.HelloService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class RpcClientManage {
    public static void main(String[] args) {
        HelloService proxyService = getProxyService(HelloService.class);
        String s = proxyService.sayHello("张三");
        int ss = proxyService.doSome("ss");
    }

    public static <T> T getProxyService(Class<T> serviceClass){
        ClassLoader loader = serviceClass.getClassLoader();
        Class[] interfaces = new Class[]{serviceClass};
        Object o = Proxy.newProxyInstance(loader, interfaces, (proxy, method, args) -> {
            // 1. 将方法的调用转换为消息对象
            int sequenceId = SequenceIdGenerator.nextId();
            RpcRequestMessage msg = new RpcRequestMessage(
                    sequenceId,
                    serviceClass.getName(),
                    method.getName(),
                    method.getReturnType(),
                    method.getParameterTypes(),
                    args
            );
            // 2. 发送消息对象
            getChannel().writeAndFlush(msg);
            // 3. 准备一个 Promise 对象，用来接收结果  指定 promise 对象接收结果的线程
            DefaultPromise<Object> promise = new DefaultPromise<>(getChannel().eventLoop());
            RpcResponseMessageHandler.PROMISES.put(sequenceId,promise);

            promise.addListener(future -> {
                // 线程
            });

            // 等待 结果
            promise.await();
            if(promise.isSuccess()){
                // 调用正常
                 return promise.getNow();
            }else{
                throw new RuntimeException(promise.cause());
            }

        });
        return (T) o;
  }


    private static Channel channel = null;
    private static  final Object LOCK = new Object();

    // 获取 唯一的 channel 对象
    public static Channel getChannel(){
        if(channel!=null){
            return channel;
        }
        synchronized (LOCK){  // t1 t2
            if(channel != null){   // t1
                return  channel;
            }
            initChannel();
            return channel;
        }
    }

    // 初始化channel 方法
    private static void initChannel() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        RpcResponseMessageHandler RPC_HANDLER = new RpcResponseMessageHandler();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(group);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ProcotolFrameDecoder());
                ch.pipeline().addLast(LOGGING_HANDLER);
                ch.pipeline().addLast(MESSAGE_CODEC);
                ch.pipeline().addLast(RPC_HANDLER);
            }
        });

        try {
            // 这里要同步，否则channel 没有就绪
            channel = bootstrap.connect("localhost", 8081).sync().channel();

            channel.closeFuture().addListener(future -> {
                group.shutdownGracefully();
            });
        } catch (Exception e) {
            log.error("client error", e);
        }
    }
}

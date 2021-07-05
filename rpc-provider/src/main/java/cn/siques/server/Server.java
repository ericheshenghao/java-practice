package cn.siques.server;

import cn.siques.codec.MessageCodec;
import cn.siques.codec.ProtoFrameDecoder;
import cn.siques.handler.RpcRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques.server
 * @Description:
 * @date : 2021/7/5 12:45
 */
@Component
public class Server {
    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;


    @PostConstruct
    public void start() throws InterruptedException {
        RpcRequestHandler handler = new RpcRequestHandler();
        // 将new出的对象放入Spring容器中
        defaultListableBeanFactory.registerSingleton("rpcRequestHandler",handler);
        // 自动注入依赖
        beanFactory.autowireBean(handler);
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new ProtoFrameDecoder());
                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new MessageCodec());
                        ch.pipeline().addLast(handler);
                    }
                });
        Channel channel = serverBootstrap.bind(11001).sync().channel();
        channel.closeFuture().addListener(future -> {
            group.shutdownGracefully();
        });

    }
}

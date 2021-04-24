package cn.siques.参数;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : heshenghao
 * @date : 15:04 2021/4/20
 */
@Slf4j
public class TestConnectionTimeout {
    public static void main(String[] args) {
        // 1. 客户端通过 .option() 是给 SocketChannel 方法配置参数

//        new ServerBootstrap().option(); // 是给 serverSocketChannel 配置参数
//        new ServerBootstrap().childHandler(); // 是给 SocketChannel 配置参数

        NioEventLoopGroup group = new NioEventLoopGroup();


        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,300)
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler());
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8081);
            future.sync().channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("timeout");
        } finally {
            group.shutdownGracefully();
        }
    }
}

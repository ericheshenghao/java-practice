package cn.siques.手写RPC框架.server;

import cn.siques.手写RPC框架.codec.MessageCodec;
import cn.siques.手写RPC框架.codec.ProtoFrameDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author : heshenghao
 * @date : 14:32 2021/4/24
 */
public class RpcServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) {
                            ch.pipeline().addLast(new ProtoFrameDecoder());
                            ch.pipeline().addLast(new LoggingHandler());
                            ch.pipeline().addLast(new MessageCodec());
                            ch.pipeline().addLast(new RpcRequestHandler());
                        }
                    });
            Channel channel = serverBootstrap.bind(8081).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}

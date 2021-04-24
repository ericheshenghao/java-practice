package cn.siques.c3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @author : heshenghao
 * @date : 16:01 2021/4/18
 */
@Slf4j
public class EventLoopClient {
    public static void main(String[] args) throws InterruptedException {

        ChannelFuture channelFuture = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)

                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 异步的非阻塞方法，主线程发起调用，但是委托给别的线程执行连接，因此直接返回结果
                .connect(new InetSocketAddress("localhost",8081));
//                .connect("localhost", 8081);


        // 1 . 调用直到来连接建立完成
//        channelFuture.sync();  //阻塞，直到Nio线程建立完毕
//        Channel channel = channelFuture.channel();
//        log.debug("{}",channel);
//        channel.writeAndFlush("s1");

        // 2. addListener 方法异步处理结果
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            // 再 nio 线程连接建立好之后，会调用operationComplete
            public void operationComplete(ChannelFuture future) throws Exception {
                Channel channel = future.channel();
                log.debug("{}",channel);
                channel.writeAndFlush("s1");
            }
        });


    }
}

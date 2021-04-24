package cn.siques.EchoServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author : heshenghao
 * @date : 14:04 2021/4/19
 */
@Slf4j
public class EchoServer {
    public static void main(String[] args) {
        new ServerBootstrap().group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                 .childHandler(new ChannelInitializer<NioSocketChannel>() {
                     @Override
                     protected void initChannel(NioSocketChannel ch) throws Exception {


                         ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                             @Override
                             public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf =  msg instanceof ByteBuf? ((ByteBuf) msg):null;
                                log.debug("{}",msg);
                                 ByteBuf buf1 = ctx.alloc().buffer().writeBytes(buf);
                                 buf.release();
                                 ctx.writeAndFlush(buf1);
                             }

                         });


                     }
                 })
                .bind(8081);
    }
}

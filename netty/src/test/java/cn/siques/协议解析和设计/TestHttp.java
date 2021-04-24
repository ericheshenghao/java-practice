package cn.siques.协议解析和设计;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;

/**
 * @author : heshenghao
 * @date : 18:43 2021/4/19
 */
@Slf4j
public class TestHttp {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.group(boss,worker);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {

                    ch.pipeline().addLast(new LoggingHandler());
                    //
                    ch.pipeline().addLast(new HttpServerCodec());
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpRequest>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, HttpRequest msg) throws Exception {
                            // 获取请求
                            System.out.println(msg.uri());
                            // 返回响应
                            DefaultFullHttpResponse response = new DefaultFullHttpResponse(msg.protocolVersion()
                                    ,HttpResponseStatus.OK);
                            byte[] bytes = "<h1>Hello,world!</h1>".getBytes();
                            response.headers().setInt(CONTENT_LENGTH,bytes.length);
                            response.content().writeBytes(bytes);
                            // 写回响应
                            ctx.writeAndFlush(response);
                        }
                    });
//                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
//                        @Override
//                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                            log.debug("{}",msg.getClass());
//                            if(msg instanceof HttpRequest){
//
//                            } else if(msg instanceof HttpContent){
//
//                            }
//                        }
//                    });
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8081).sync();
            channelFuture.channel().closeFuture().sync();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
          boss.shutdownGracefully();
          worker.shutdownGracefully();
        };
    }
}

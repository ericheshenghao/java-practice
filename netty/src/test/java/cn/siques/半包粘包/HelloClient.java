package cn.siques.半包粘包;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author : heshenghao
 * @date : 16:01 2021/4/18
 */
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10 ; i++) {
            send();
        }

        System.out.println("finish");
    }
    private static void send(){
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            new Bootstrap()
                    // 2. 添加 EventLoop
                    .group(worker)
                    // 3. 选择客户端的channel 实现
                    .channel(NioSocketChannel.class)
                    //4. 添加处理器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                // 会在连接channel 建立连接后，触发 active 事件
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {

                                    ByteBuf buf = ctx.alloc().buffer(16);
                                    buf.writeBytes(new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17});
                                    ctx.writeAndFlush(buf);
                                    ctx.channel().close();
                                }
                            });
                        }


                    })
                    .connect("localhost",8081)
                    .sync();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
    }
}

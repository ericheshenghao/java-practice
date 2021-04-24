package cn.siques.半包粘包.行解码器;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : heshenghao
 * @date : 16:01 2021/4/18
 */
public class Client3 {
    public static void main(String[] args) throws InterruptedException {
      send();
        System.out.println("finish");
    }

    public static StringBuilder makeString(char c, int len){
        StringBuilder sb = new StringBuilder(len + 2);
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }
        sb.append("\n");
        return sb;
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
                            ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                // 会在连接channel 建立连接后，触发 active 事件
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ByteBuf buf = ctx.alloc().buffer();
                                    char c = '0';
                                    Random random = new Random();
                                    for (int i = 0; i < 10; i++) {
                                        StringBuilder b = makeString(c, random.nextInt(256)+1);
                                        c++;
                                        buf.writeBytes(b.toString().getBytes());
                                    }
                                    ctx.writeAndFlush(buf);
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

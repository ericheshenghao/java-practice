package cn.siques.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author : heshenghao
 * @date : 16:01 2021/4/18
 */
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        // 1.启动器类
        new Bootstrap()
                // 2. 添加 EventLoop
                .group(new NioEventLoopGroup())
                // 3. 选择客户端的channel 实现
                .channel(NioSocketChannel.class)
                //4. 添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("localhost",8081)
                .sync() // 阻塞方法，知道连接建立后才往后运行
                .channel() // 连接的对象
                .writeAndFlush("hello,world");
    }
}

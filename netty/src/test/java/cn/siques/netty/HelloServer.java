package cn.siques.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author : heshenghao
 * @date : 15:50 2021/4/18
 */
public class HelloServer {
    public static void main(String[] args) {
        // 1. 启动器，负责组装 netty 组件，启动服务器
        new ServerBootstrap()
                // 2. BossEventLoop , WorkerEventLoop(selector, thread) 处理事件
                // group 组 负责不同的任务
                .group(new NioEventLoopGroup())
                // 3. 选择服务器 serversocketchannel 实现，
                .channel(NioServerSocketChannel.class)  //OIO BIO
                // 4. 处理器，类似于Worker 负责处理读写，决定了 worker(child) 将来做什么事情
                .childHandler(
                        // 5. 代表和客户端进行数据读写的通道 Initializer 初始化，负责添加别的handler处理器
                        new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new StringDecoder()); // 将bytebuffer 转换为字符串
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                        @Override  // 读事件
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            // 打印上一步转换好的字符串
                            System.out.println(msg);
                        }
                    });
                    }
                })
                // 7
                .bind(8081);
    }
}


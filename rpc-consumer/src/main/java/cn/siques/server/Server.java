package cn.siques.server;

import cn.siques.codec.MessageCodec;
import cn.siques.codec.ProtoFrameDecoder;

import cn.siques.handler.RpcResponseHandler;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private NacosServiceDiscovery discovery;


    public Channel channel(String host,Integer rpcPort) throws InterruptedException {
        RpcResponseHandler handler = new RpcResponseHandler();
        // 将new出的对象放入Spring容器中
        defaultListableBeanFactory.registerSingleton("rpcResponseHandler",handler);
        // 自动注入依赖
        beanFactory.autowireBean(handler);
        // 绑定服务
        NioEventLoopGroup group = new NioEventLoopGroup();
        Channel channel = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new ProtoFrameDecoder());
                        sc.pipeline().addLast(new LoggingHandler());
                        sc.pipeline().addLast(new MessageCodec());
                        sc.pipeline().addLast(handler);
                    }
                }).connect(host, rpcPort).sync().channel();


        channel.closeFuture().addListener(future -> {
            group.shutdownGracefully();
        });

        return channel;
    }

    @PostConstruct
    public void start() throws NacosException, InterruptedException {

        List<ServiceInstance> instances = discovery.getInstances("rpc-provider");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        Map<String, String> metadata = instance.getMetadata();
        // 获取端口
        Integer rpcPort = Integer.valueOf(metadata.get("rpcPort"));

        Channel channel = channel(host, rpcPort);

        defaultListableBeanFactory.registerSingleton("channel",channel);
        // 自动注入依赖
        beanFactory.autowireBean(channel);
    }
}

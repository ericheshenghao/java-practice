package cn.siques.源码断点剖析;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author : heshenghao
 * @date : 13:23 2021/4/23
 */
public class TestEventLoop {
    public static void main(String[] args) {
        EventLoop next = new NioEventLoopGroup().next();
        next.execute(()->{
            System.out.println(123);
        });
    }
}

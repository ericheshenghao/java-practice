package cn.siques.c3;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @author : heshenghao
 * @date : 19:12 2021/4/18
 */
@Slf4j
public class TestNettyPromise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 准备Eventloop 对象
        NioEventLoopGroup group = new NioEventLoopGroup();
        EventLoop eventLoop = group.next();
        // 2.可以主动创建 promises , 作为结果的容器
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventLoop);
        new Thread(()->{
            //3. 执行计算，填充结果
            log.debug("开始计算...");

           try {
               int i = 1/0;
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
               promise.setFailure(e);
           }
           promise.setSuccess(1);
        }).start();
        // 4. 接收结果
        log.debug("等待结果");
        log.debug("结果是{}",promise.get());
    }
}

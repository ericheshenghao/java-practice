package cn.siques.c4;

import lombok.extern.slf4j.Slf4j;

import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 22:51 2021/4/17
 */
@Slf4j
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        Selector boss = Selector.open();
        SelectionKey bossKey = ssc.register(boss, 0, null);
        bossKey.interestOps(SelectionKey.OP_ACCEPT);
        ssc.bind(new InetSocketAddress(8081));
        // 1.创建固定数量的worker 并初始化
        Worker[] workers = new Worker[Runtime.getRuntime().availableProcessors()];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("worker-"+i);
        }
        AtomicInteger index = new AtomicInteger();

        while (true){
            boss.select();
            Iterator<SelectionKey> iter = boss.selectedKeys().iterator();
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                iter.remove();
                if(key.isAcceptable()){
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    log.debug("connected...{}",sc.getRemoteAddress());
                    // 2.关联
                    log.debug("before register...{}",sc.getRemoteAddress());
                    // round robin 轮询 ，是否会有溢出的问题
                    workers[index.getAndIncrement() % workers.length].register(sc);

                    log.debug("after register...{}",sc.getRemoteAddress());
                }
            }
        }
    }

    static class Worker implements Runnable{
        private Thread thread;
        private Selector selector;
        private String name;
        private boolean start = false; // 初始化
        private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();


        public Worker(String name){
            this.name = name;
        }
        // 初始化线程和 selector
        public void register(SocketChannel sc) throws IOException {
            if(!start){
                thread = new Thread(this,name);
                // 新建一个selector 用来处理worker 接收的任务
                selector = Selector.open();
                thread.start();
                start = true;
            }
            queue.add(()->{
                try {
                    // 注册读事件
                    sc.register(selector,SelectionKey.OP_READ, null);
                }catch(ClosedChannelException e){
                    e.printStackTrace();
                }
            });

            selector.wakeup();  // 唤醒 selector
        }

        @Override
        public void run() {

            while(true){
                try {
                    selector.select();

                    Runnable task = queue.poll();
                    if(task!=null) task.run(); // 执行了注册

                    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                    while(iter.hasNext()){
                        SelectionKey key = iter.next();
                        iter.remove();
                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                            log.debug("read...{}",channel.getRemoteAddress());
                            channel.read(buffer);
                            buffer.flip();
                            debugAll(buffer);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

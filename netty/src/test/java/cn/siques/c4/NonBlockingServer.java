package cn.siques.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static cn.siques.ByteBufferUtil.debugAll;
import static cn.siques.ByteBufferUtil.debugRead;

/**
 * 非阻塞
 * @author : heshenghao
 * @date : 20:38 2021/4/16
 */
@Slf4j
public class NonBlockingServer {
    public static void main(String[] args) throws IOException {
        // 1. 创建selector，管理多个 channel
        Selector selector = Selector.open();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        // 2. 建立selector 和 channel 的联系（注册）
        // SelectionKey 事件发生后通过它可以知道事件和发生事件的channel
        SelectionKey sscKey = ssc.register(selector, 0, null);
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("register key:{}",sscKey);
        ssc.bind(new InetSocketAddress(8081));
        while(true){
            // 3. select 方法，没有事件就阻塞，否则向下处理事件
            // select 事件未处理时，不会阻塞，要么取消不能置之不理
            selector.select();
            // 4. 处理事件，selectedKeys 内部包含了所有发生的事件
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                // 处理key时，要从 selectedKeys 集合中删除，否则下次处理就会有问题
                iter.remove();
                log.debug("key:{}",key);
                // 5.区分事件类型
                if (key.isAcceptable()) {
                    ServerSocketChannel channel =(ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    // 初始容量
                    ByteBuffer buffer = ByteBuffer.allocate(16);// attachment
                    // 将Bytebuffer作为附件关联到 selectionKey上
                    SelectionKey scKey = sc.register(selector, 0, buffer);
                    scKey.interestOps(SelectionKey.OP_READ);
                    log.debug("{}",sc);
                    log.debug("scKey:{}",scKey);
                }else if(key.isReadable()){
                    try {
                        SocketChannel channel =(SocketChannel) key.channel();
                        // 获取 附件
                        ByteBuffer buffer =(ByteBuffer) key.attachment();
                        int read = channel.read(buffer); // 如果是正常断开，返回-1
                        if(read == -1){
                            // 读取完断开事件
                            key.cancel();
                        }else {
                            // 拆包
                          split(buffer);
                          // 扩容机制
                          if(buffer.position()== buffer.limit()){
                              ByteBuffer newBuffer = ByteBuffer.allocate(buffer.capacity()*2);
                              buffer.flip();
                              newBuffer.put(buffer);
                              key.attach(newBuffer);
                          }
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                        key.cancel(); // 删除key
                    };
                }

            }
        }

    }

    private static void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            // 找到完整的消息
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                // 把这条消息存入新的ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从source 读，向target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact(); // 0123456789abcdef position 16 limit 16
    }
}

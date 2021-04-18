package cn.siques.c5;

import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 15:30 2021/4/18
 */
@Slf4j
public class AioFileChannel {
    public static void main(String[] args) {
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("netty/data.txt"), StandardOpenOption.READ)) {
            // 参数1 ByteBuffer
            // 参数2 读取的起始位置
            // 参数3 附件
            // 参数4 回调方法
            ByteBuffer buffer = ByteBuffer.allocate(16);
            log.debug("read begin...");
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override //read 成功
                public void completed(Integer result, ByteBuffer attachment) {
                    log.debug("read completed...");
                    attachment.flip();
                    debugAll(attachment);
                }

                @Override  // read 失败
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });
            Thread.sleep(1000);
            log.debug("read end...");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

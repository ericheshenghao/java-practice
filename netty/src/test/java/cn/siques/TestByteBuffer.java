package cn.siques;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : heshenghao
 * @date : 16:22 2021/4/16
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
//        System.out.println(System.getProperty(
//                "user.dir"
//        ));
        // FileChannel 代表数据的读写通道
        // 1. 输入输出流 2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("netty/data.txt").getChannel()) {
            // 准备缓冲区 划分十个字节
            ByteBuffer buffer = ByteBuffer.allocate(10);
            //从 Channel 读取，向buffer写
            while(true){
                int len = channel.read(buffer);
                log.debug("读取到的字节数{}", len);
                if(len == -1) break;

                // 打印 buffer 内容
                buffer.flip(); // 切换到buffer的读模式
                while(buffer.hasRemaining()){  // 检查是否有剩余
                    byte b = buffer.get();
                    log.debug("读取到的字节{}", (char) b);
                }
                // 切换为写模式
                buffer.clear();
            }
        } catch (IOException e) {

        }

    }
}

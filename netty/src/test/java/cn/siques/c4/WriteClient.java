package cn.siques.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author : heshenghao
 * @date : 22:45 2021/4/16
 */
public class WriteClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8081));
       // 3.接收数据
        int count = 0;
        while(true){
            ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
            count += sc.read(buffer);
            System.out.println(count);
            buffer.clear();
        }
    }
}

package cn.siques.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author : heshenghao
 * @date : 20:46 2021/4/16
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8081));
        sc.write(Charset.defaultCharset().encode("0123456789abcdef2222\nworld\n"));
        System.in.read();

    }
}

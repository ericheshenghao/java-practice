package cn.siques.半包粘包.LTC解码器;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author : heshenghao
 * @date : 17:59 2021/4/19
 */
public class TestLengthFieldDecoder {
    public static void main(String[] args) {
        EmbeddedChannel channel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(1024,0,4,0,4),
                new LoggingHandler(LogLevel.DEBUG));

        // 4 个字节的内容长度
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        send(buffer,"Hello, world");
        send(buffer,"Hi!");
        channel.writeInbound(buffer);
    }


    private static void  send(ByteBuf buf ,String content){
        byte[] bytes = content.getBytes();
        int length = bytes.length;
        buf.writeInt(length);
        buf.writeByte(1);
        buf.writeBytes(bytes);
    }
}

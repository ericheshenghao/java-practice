package cn.siques.protocol;

import cn.siques.message.LoginRequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : heshenghao
 * @date : 19:46 2021/4/19
 */
@Slf4j
public class TestMessageCodec {
    public static void main(String[] args) throws Exception {

        // 解码器, 只是线程执行的工具
        // 工人 1 收到 1234 半包
        // 工人 2 另一半包到这里了，出现问题
        LengthFieldBasedFrameDecoder FRAME_DECODER  = new LengthFieldBasedFrameDecoder(1024, 12, 4, 0, 0);

        EmbeddedChannel channel = new EmbeddedChannel(
                FRAME_DECODER,
                new LoggingHandler(),
                new MessageCodec());

        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123");
//        channel.writeOutbound(message);

        // decode
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        new MessageCodec().encode(null,message,buf);

        ByteBuf s1 = buf.slice(0, 50);
        ByteBuf s2 = buf.slice(50, buf.readableBytes() - 50);
        channel.writeInbound(s1);
        s1.retain();
        channel.writeInbound(s2);
//        // 入栈
//        channel.writeInbound(buf);

    }
}

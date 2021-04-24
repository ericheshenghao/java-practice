package cn.siques.c5;

import cn.siques.message.LoginRequestMessage;
import cn.siques.message.Message;
import cn.siques.protocol.MessageCodec;
import cn.siques.protocol.MessageCodecSharable;
import cn.siques.protocol.Serializer;
import cn.siques.聊天室.config.Config;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author : heshenghao
 * @date : 14:47 2021/4/20
 */
public class TestSerializer {
    public static void main(String[] args) {
        MessageCodecSharable codec = new MessageCodecSharable();
        LoggingHandler loggingHandler = new LoggingHandler();
        EmbeddedChannel channel = new EmbeddedChannel(loggingHandler, codec, loggingHandler);

        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123");
        // 序列化
//        channel.writeOutbound(message);
        ByteBuf buf = messageToByteBuf(message);
        // 反序列化
        channel.writeInbound(buf);
    }


    // 反序列化
    public static ByteBuf messageToByteBuf(Message msg) {
        int algorithm = Config.getSerializerAlgorithm().ordinal();
        ByteBuf out = ByteBufAllocator.DEFAULT.buffer();
        out.writeBytes(new byte[]{1, 2, 3, 4});
        out.writeByte(1);
        out.writeByte(algorithm);
        out.writeByte(msg.getMessageType());
        out.writeInt(msg.getSequenceId());
        out.writeByte(0xff);
        byte[] bytes = Serializer.Algorithm.values()[algorithm].serialize(msg);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
        return out;
    }
}

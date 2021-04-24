package cn.siques.protocol;

import cn.siques.message.Message;
import cn.siques.聊天室.config.Config;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 必须和 lengthFieldBasedFrameDecoder 一起使用，确保不会出现半包
 * @author : heshenghao
 * @date : 20:34 2021/4/19
 */
@ChannelHandler.Sharable
@Slf4j
public class MessageCodecSharable extends MessageToMessageCodec<ByteBuf, Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> outList) throws Exception {
        ByteBuf out = ctx.alloc().buffer();
        // 1. 4字节的魔数
        out.writeBytes(new byte[]{1,2,3,4});
        // 2. 1 字节的版本,
        out.writeByte(1);
        // 3. 1 字节的序列化方式  0 jdk 1 json
        out.writeByte(Config.getSerializerAlgorithm().ordinal());
        // 4. 1 字节的指令类型
        out.writeByte(msg.getMessageType());
        // 5. 四个字节的 序列id
        out.writeInt(msg.getSequenceId());
        // 对齐填充
        out.writeByte(0xff);
        // 6. 获取内容的字节数组
        byte[] bytes = Config.getSerializerAlgorithm().serialize(msg);

        // 7. 长度
        out.writeInt(bytes.length);

        // 8. 写入内容
        out.writeBytes(bytes);
        outList.add(out);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> outList) throws Exception {

        int magicNum = in.readInt();
        byte version = in.readByte();
        // 序列化算法
        byte serializerAlgorithm = in.readByte();
        byte msgType = in.readByte();
        int sequenceId = in.readInt();
        in.readByte();
        int length = in.readInt();
        byte[] bytes = new byte[length];
        in.readBytes(bytes,0,length);

        // 确定反序列化算法
        Serializer.Algorithm algorithm = Serializer.Algorithm.values()[serializerAlgorithm];
        // 根据msgType获取实际消息类型
        Class<? extends Message> messageClass = Message.getMessageClass(msgType);
        Object msg = algorithm.deserialize(messageClass, bytes);
//        log.debug("{},{},{},{},{},{}",magicNum,version,serializerType,msgType,sequenceId,length);
//        log.debug("{}",msg);
        outList.add(msg);
    }
}

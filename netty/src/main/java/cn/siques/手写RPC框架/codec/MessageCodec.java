package cn.siques.手写RPC框架.codec;

import cn.siques.手写RPC框架.message.Message;
import cn.siques.手写RPC框架.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author : heshenghao
 * @date : 17:19 2021/4/24
 */
public class MessageCodec extends MessageToMessageCodec<ByteBuf, Message> {
    /**
     * 将消息转换为byte数组传输
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        ByteBuf buf = ctx.alloc().buffer();
        // 1. 4字节的魔数
        buf.writeBytes(new byte[]{1,2,3,4});
        // 2. 1 字节的版本,
        // 3. 1 字节的序列化方式  0 jdk 1 json
        // 4. 1 自己的指令类型
        // 5. 四个字节的 序列id
        // 对齐填充
        // 6. 获取内容的字节数组
        // 7. 长度
        // 8. 写入内容
        buf.writeByte(0xff);

        buf.writeByte(1);
        buf.writeByte(0);
        buf.writeByte(msg.getMsgType());
        // 16 字节的 uuid
        buf.writeBytes(msg.getSequenceId().getBytes());

        byte[] bytes = Serializer.Algorithm.Java.serialize(msg);

        buf.writeInt(bytes.length);
        buf.writeBytes(bytes);
        out.add(buf);
    }

    /**
     * 将byte数组转换为msg对象
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int magicNum = in.readInt();
        in.readByte();

        byte version = in.readByte();
        byte serializeType = in.readByte();
        byte msgType = in.readByte();
        ByteBuf sequenceId = in.readBytes(36);
        int length = in.readInt();
        byte[] bytes = new byte[length];
        in.readBytes(bytes);
        Class msgClass = Message.getMessageClass(msgType);
        System.out.println(msgClass);
        Object msg = Serializer.Algorithm.Java.deserialize(msgClass, bytes);
        out.add(msg);
    }
}

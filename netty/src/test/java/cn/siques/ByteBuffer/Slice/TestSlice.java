package cn.siques.ByteBuffer.Slice;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import static cn.siques.ByteBuffer.TestByteBuf.log;

/**
 * @author : heshenghao
 * @date : 13:45 2021/4/19
 */
public class TestSlice {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        buf.writeBytes(new byte[]{'a','b','c','d','e','f','g','h','i','j'});
        log(buf);

        //在切片过程中，没有发生数据的复制
        ByteBuf f1 = buf.slice(0, 5);
        ByteBuf duplicate = buf.duplicate();

        // 引用计数 + 1， 正确用法是 每次切片时使该数加 1 ，这样原始bytebuf释放时
        // 不会影响到f1, 将f1的释放交给 f1自己
        f1.retain();
        // 'a','b','c','d','e','x'
        ByteBuf f2 = buf.slice(5, 5);
        log(f1);
        log(f2);
        // 释放原有 byteBuf 内存
        buf.release();
        log(f1);
//        f1.writeByte('x');
//        System.out.println("===================");
//        f1.setByte(0,'b');
//        log(f1);
//        log(buf);
    }
}

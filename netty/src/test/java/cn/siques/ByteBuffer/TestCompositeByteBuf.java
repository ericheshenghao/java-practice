package cn.siques.ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

import static cn.siques.ByteBuffer.TestByteBuf.log;

/**
 * @author : heshenghao
 * @date : 13:57 2021/4/19
 */
public class TestCompositeByteBuf {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        buf.writeBytes(new byte[]{1,2,3,4,5});

        ByteBuf buf1 = ByteBufAllocator.DEFAULT.buffer();
        buf1.writeBytes(new byte[]{6,7,8,9,10,11,12,13,14,15,16,17});


//        ByteBuf buf2 = ByteBufAllocator.DEFAULT.buffer();
//        buf2.writeBytes(buf1).writeBytes(buf2);
//        log(buf);
        CompositeByteBuf bufs = ByteBufAllocator.DEFAULT.compositeBuffer();
        bufs.addComponents(true,buf,buf1);
        log(bufs);

    }
}

package cn.siques;

import java.nio.ByteBuffer;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 16:58 2021/4/16
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61); // a
        debugAll(buffer);
        buffer.put(new byte[]{0x62,0x63,0x64});// b c d
        debugAll(buffer);
        buffer.flip();
        System.out.println(buffer.get());
        buffer.compact();
        debugAll(buffer);
        buffer.put(new byte[]{0x65,0x66});// e f
        debugAll(buffer);
    }
}

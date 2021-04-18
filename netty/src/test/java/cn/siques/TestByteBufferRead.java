package cn.siques;

import java.nio.ByteBuffer;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 17:13 2021/4/16
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

//        // rewind 从头开始读
//        buffer.get(new byte[4]);
//        debugAll(buffer);
//        buffer.rewind();
//        System.out.println((char) buffer.get());

        // mark & reset
        // mark 做一个标记，记录position 位置，
        // reset 是将 position跳转到 mark 位置
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        buffer.mark(); // 加标记，索引2 的位置
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        buffer.reset();
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        debugAll(buffer);

        // get(i)
        System.out.println((char) buffer.get(3));
        debugAll(buffer);

    }
}

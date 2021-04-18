package cn.siques;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 17:21 2021/4/16
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        // 1. 字符串转为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        // 2. Charset
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
        debugAll(hello);

        // 3. wrap
        ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes());
        debugAll(wrap);

        // 2 和 3可以，因为已经是读模式
        String s = StandardCharsets.UTF_8.decode(wrap).toString();
        System.out.println(s);
    }
}

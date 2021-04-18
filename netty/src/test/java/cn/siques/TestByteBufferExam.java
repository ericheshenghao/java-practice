package cn.siques;

import java.nio.ByteBuffer;

import static cn.siques.ByteBufferUtil.debugAll;

/**
 * @author : heshenghao
 * @date : 19:09 2021/4/16
 */
public class TestByteBufferExam {
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            // 找到完整的消息
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                // 把这条消息存入新的ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从source 读，向target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact();
    }
}

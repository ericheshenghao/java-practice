package cn.siques;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author : heshenghao
 * @date : 19:26 2021/4/16
 */
public class TextFileChannelTransferTo {
    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("netty/data.txt").getChannel();
             FileChannel to = new FileOutputStream("netty/to.txt").getChannel()
        ) {
            // 效率较高，底层利用操作系统的零拷贝进行优化，一次最多传2G
            long size = from.size();
            // left变量表示还剩余多少字节
            for (long left = size; left > 0;){
                long l = from.transferTo((size - left), left, to);
                left -= l;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

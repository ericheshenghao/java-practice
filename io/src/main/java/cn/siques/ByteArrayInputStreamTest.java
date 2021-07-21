package cn.siques;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques
 * @Description:
 * @date : 2021/7/16 16:50
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {
        String content = "你好，java Block I/O";
        byte[] input = content.getBytes(Charset.forName("utf-8"));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);

        byte[] bytes = new byte[1024];

        int size = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while((size = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,size);
        }
        System.out.println(outputStream.toString("utf-8"));
    }
}

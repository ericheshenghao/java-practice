package cn.siques;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: cn.siques
 * @Description:
 * @date : 2021/7/16 16:50
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = null;
        FileInputStream fileInputStream =null;
        File src = new File("io/src/main/resources/src.txt");
        File target = new File("io/src/main/resources/target.txt");

        try {
          fileInputStream = new FileInputStream(src);
          outputStream = new FileOutputStream(target);
          int byt;
          while ((byt = fileInputStream.read())!=-1){
              outputStream.write(byt);
          }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
        }
    }
}

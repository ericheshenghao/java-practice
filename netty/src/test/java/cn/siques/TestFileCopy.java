package cn.siques;

import sun.security.krb5.internal.PAData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : heshenghao
 * @date : 20:24 2021/4/16
 */
public class TestFileCopy {
    /**
     * 多级目录的拷贝
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String source = "path:1";
        String target = "path:2";
        Files.walk(Paths.get(source)).forEach(path -> {
            try {
               String targetName = path.toString().replace(source,target);
                // 目录
                if(Files.isDirectory(path)){
                    Files.createDirectory(Paths.get(targetName));
                    // 普通文件
                }else if(Files.isReadable(path)){
                    Files.copy(path,Paths.get(targetName));
                }

            }catch(Exception e){
                e.printStackTrace();
            };

          } );
    }
}

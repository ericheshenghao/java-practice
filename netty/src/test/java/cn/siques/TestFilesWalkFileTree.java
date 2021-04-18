package cn.siques;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : heshenghao
 * @date : 20:09 2021/4/16
 */
public class TestFilesWalkFileTree {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("D:\\web\\java-practice\\netty\\src\\test\\deleted"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              // 删文件
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                // 删文件夹
                System.out.println("退出");
                return super.postVisitDirectory(dir, exc);
            }
        });

    }

    public static void m2() throws IOException {
        AtomicInteger jarCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("D:\\web\\java-practice"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(file.toString().endsWith(".jar")){
                    System.out.println(file);
                    jarCount.getAndIncrement();
                }
                return super.visitFile(file, attrs);
            }
        });
        System.out.println(jarCount);
    }

    public static void m1() throws IOException {
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("D:\\web\\java-practice"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("====>"+dir);
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }


        });
        System.out.println(dirCount);
        System.out.println(fileCount);
    }
}

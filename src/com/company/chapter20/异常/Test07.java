package com.company.chapter20.异常;

import jdk.nashorn.api.scripting.URLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
深入 try catch
可以写多个精确的一个一个处理
 */
public class Test07 {
    public static void main(String[] args) {


//        try {
//            FileInputStream fis = new FileInputStream("D:\\素材\\test.txt");
//            fis.read();
//        }
//        catch(FileNotFoundException e){
//
//        }catch (IOException e){
//
//        };
        // 新特性
        try {
            FileInputStream fis = new FileInputStream("D:\\素材\\test.txt");

            System.out.println(100 / 0);
        } catch (FileNotFoundException | ArithmeticException e) {
            System.out.println("文件不存在或者运算问题");
        }
        ;

    }
}

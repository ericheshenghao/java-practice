package com.company.chapter20.IO流.FileReader;

import java.io.FileWriter;
import java.io.IOException;

/*
文件字符输出流
负责写
只能输出普通文本
 */
public class Test02 {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            out = new FileWriter("src/com/company/chapter20/IO流/temp1.txt");
            // 开始写
            char[] chars = {'我', '是', '中', '国'};
            out.write(chars);
            out.write(chars, 1, 3);
            out.write("\n");
            out.write("我是一名软件工程师");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

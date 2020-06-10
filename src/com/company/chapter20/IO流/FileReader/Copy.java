package com.company.chapter20.IO流.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 只能拷贝普通的文本文件
 */
public class Copy {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("src/com/company/chapter20/IO流/temp1.txt");

            fileWriter = new FileWriter("src/com/company/chapter20/IO流/temp2.txt");

            char[] chars = new char[1024 * 512];

            int readCout = 0;
            while ((readCout = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, readCout);
            }


            fileWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

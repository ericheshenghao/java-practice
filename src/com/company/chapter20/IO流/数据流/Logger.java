package com.company.chapter20.IO流.数据流;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
日志工具
 */
public class Logger {
    public static void log(String msg) {

        try {
            PrintStream out = new PrintStream(new FileOutputStream("src/com/company/chapter20/IO流/log.txt", true));
            // 改变输出方向
            System.setOut(out);
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strtiME = sdf.format(now);
            System.out.println(strtiME + ": 发生了" + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

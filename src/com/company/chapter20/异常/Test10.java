package com.company.chapter20.异常;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
关于trvcatch种的finally
1.最后执行的，一定会执行
    不能单独编写
2.哪些情况下
  通常在finally种的完成资源的释放，
  即使出现错误，也能关闭资源，防止资源的浪费
 */
public class Test10 {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\素材\\test1.txt");

            String s = null;
            // 这里一定会出现空指针异常
            s.toString();
            // 使用完后关闭
            // 即使出现异常，流也需要关闭
            // 放在这里可能关不了
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            // 所以流的关闭需要放在这里
            if (file != null) {
                try {
                    file.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;
            }
        }
        ;

        System.out.println("hello world ");


    }
}
